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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
    //订单添加接口
    @Autowired
    DataSourceTransactionManager transactionManager;


    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public Order insertOrder(int ticket_num,double total_price,int user_id,int platon_id,int[] seat_ids){
        //查询选座表，判断当前用户的选座是否还存在

        if(seatService.seatsIsBeOccupied(seat_ids)){
            return null;
        }

//        String s = null;
//        if(!s.equals("")){
//            System.out.println("异常异常异常");
//        }

        //查询缓存，看是否有该用户的订单
        String key = "order_" + user_id;
        String orderJson = redis.getValueByKey(key);
        if (orderJson != null&&!orderJson.equals("")) {
            Gson gson = new Gson();
            Order order = gson.fromJson(key,Order.class);
            userInfoOrder.deleteOrderById(order.getId(),2);
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
        }
        //从数据库中获取该订单
        Order myOrder = orderDaoRead.selectOrderByID(order.getId());
        //将订单保存到缓存中，在该项目中，一个用户同一时间只能有一个未支付订单
        Gson gson = new Gson();
        redis.saveStringToSet(key,gson.toJson(myOrder),15);
        //15分钟后清除缓存中的订单数据
        userInfoService.deleteOrder(order.getId());

        return myOrder;
    }

}
