package com.ticket.insertOrder.Service;

import com.google.gson.Gson;
import com.ticket.UserInfo.UserInfoDAO.impl.UserInfoDAO;
import com.ticket.UserInfo.UserInfoService.IUserInfoService;
import com.ticket.UserInfo.userInfoReadDAO.impl.UserInfoOrder;
import com.ticket.film.service.SeatService;
import com.ticket.insertOrder.bean.Order;
import com.ticket.insertOrder.bean.Seat_Occupied;
import com.ticket.insertOrder.daoRead.OrderDaoRead;
import com.ticket.insertOrder.daoWrite.OrderDao;
import com.ticket.insertOrder.daoWrite.Seat_occupiedDao;
import com.ticket.loginandregister.redis.Redis;
import net.sf.json.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    Redis redis;

    @Autowired
    Seat_occupiedDao seat_occupiedDao;

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderDaoRead orderDaoRead;

    @Autowired
    UserInfoDAO userInfoOrder;

    @Autowired
    IUserInfoService userInfoService;

    @Autowired
    JmsTemplate jmsTemplateSendMsg;

    @Autowired
    SeatService seatService;
    @Autowired
    StringRedisTemplate redisTemplate;
    //订单添加接口
    @Autowired
    DataSourceTransactionManager transactionManager;

    //    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public Order insertOrder(int ticket_num, double total_price, int user_id, int platon_id, int[] seat_ids) {
        //查询选座表，判断当前用户的选座是否还存在
        if (seatService.seatsIsBeOccupied(seat_ids, platon_id)) {
            //以下提醒用户，“座位已被占，请刷新页面”
            return null;
        }
        //利用redis事务和watch方法，解决座位的线程安全问题================================↓↓↓↓↓↓↓↓↓↓↓↓
        //生成座位id的key
        for(int i = 0 ;i < seat_ids.length; i++) {
            String keyForSecurity = String.valueOf("test_" + seat_ids[i]+"_platoon_"+platon_id);
            if (!redisTemplate.hasKey(keyForSecurity)) {
                //初始化座位seatStatus = 0,0为初始值,用于watch监听,并发的话重置而已，不影响安全
                redis.saveString(keyForSecurity, "0");
            }
            //以上面的key取座位的状态信息
            String strSeatStatus = redisTemplate.opsForValue().get(keyForSecurity);
            int seatStatus = Integer.valueOf(strSeatStatus);
            //判断是否被占座
            if (seatStatus != 1) {
                //以下代码并发下会被多线程访问，知道座位状态被修改，才不会有线程 进来
                //开启redis事务支持
                redisTemplate.setEnableTransactionSupport(true);
                //监听座位id的key
                redisTemplate.watch(keyForSecurity);
                //开启事务
                redisTemplate.multi();
                //修改座位状态（占座）
                redisTemplate.opsForValue().set(keyForSecurity, "1");
                //!!!!!坑！！！！额外加一次查询，不然exec提交始终返回空
                redisTemplate.opsForValue().get(keyForSecurity);
                //睡眠，测试用，使并发测试的所有线程都能进入占座的事务操作
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //提交事务
                List<Object> list = redisTemplate.exec();
                //如果返回不为空，证明当前线程的事务提交成功，否则失败
                if (list == null || list.size() == 0) {
                    //提醒用户,"同时多人选座,您慢了一点点"
                    return null;
                } else {
                    //=========================================================↑↑↑↑↑↑↑↑↑↑↑↑↑↑
                    //选座操作数据库的逻辑
                    System.out.println("+++++++修改成功");
                    //查询缓存，看是否有该用户的订单
                    String key = "order_" + user_id;
                    String orderJson = redis.getValueByKey(key);
                    if (orderJson != null && !orderJson.equals("")) {
                        Gson gson = new Gson();
                        Order order = gson.fromJson(key, Order.class);
                        userInfoOrder.deleteOrderById(order.getId(), 2);
                        //清空该缓存
                        redis.deleteKeyValue(key);
                    }
                    //获得当前时间
                    Date date = new Date();
                    Order order = new Order();
                    //计算总价
                    double totalPrice = total_price;
                    //包装order
                    order.setUserId(user_id);
                    order.setPlatoonId(platon_id);
                    order.setTicketNum(ticket_num);
                    order.setTotalPrice(totalPrice);
                    //刚下订单，未支付
                    order.setCostState(0);
                    //订单创建时间
                    order.setOrderTime(date);
                    //开启事务
                    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
                    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW); // 事物隔离级别，开启新事务，这样会比较安全些。
                    TransactionStatus status = transactionManager.getTransaction(def); // 获得事务状态
                    try {
                        //添加订单到数据库
                        orderDao.insertOrder(order);
                        //包装订单座位中间表
                        for (int seat_id : seat_ids
                                ) {
                            //创建订单座位中间表对象
                            Seat_Occupied seat_occupied = new Seat_Occupied();
                            //循环添加已被占座座位的id号
                            seat_occupied.setSeat_id(seat_id);
                            //循环添加占座的订单，并将占座状态改成1，表示已占坐
                            seat_occupied.setOrder_id(order.getId());
                            seat_occupied.setSeat_occupied(1);
                            //添加到数据库
                            seat_occupiedDao.insertSeat_occupiedDao(seat_occupied);
                            //测试用空指针异常
//            String s = null;
//            if(!s.equals("")){
//                System.out.println("异常异常异常");
//            }
                            //提交事务
                            transactionManager.commit(status);
                        }


                    } catch (RuntimeException ex) {
                        transactionManager.rollback(status);
                        return null;
                    }
                    //从数据库中获取该订单
                    Order myOrder = orderDaoRead.selectOrderByID(order.getId());
                    //将订单保存到缓存中，在该项目中，一个用户同一时间只能有一个未支付订单
                    Gson gson = new Gson();
                    redis.saveStringToSet(key, gson.toJson(myOrder), 15);
                    //15分钟后清除缓存中的订单数据
                    userInfoService.deleteOrder(order.getId());

                    return myOrder;
                }
            }else {
                //提醒用户,"座位已被占，请刷新页面"
                return null;
            }
        }
        //====================================================================================
        return null;
    }

}
