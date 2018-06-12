package com.ticket.UserInfo.userInfoReadDAO.impl;


import com.ticket.UserInfo.bean.Order;
import com.ticket.UserInfo.bean.UserBean;
import com.ticket.UserInfo.redis.IRedis;
import com.ticket.UserInfo.userInfoReadDAO.IUserinfoOrder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Shinelon on 2018/6/8.
 */
@Repository
public class UserInfoOrder extends SqlSessionDaoSupport implements IUserinfoOrder {

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactoryRead) {
        super.setSqlSessionFactory(sqlSessionFactoryRead);
    }
    @Autowired
    private IRedis red;



/*
    */
/**
     *   此方法是未支付订单表查询
     * @param costState
     */
   /* @Override
    public Order selectOrder(int userId ,int costState) throws OutOfTimeYang, OrderNotExit {

        String s = Integer.toString(userId);

        String valueByKey = red.getValueByKey(s);

        Gson gson = new Gson();

        if (null != valueByKey && !valueByKey.isEmpty()) {
            //缓存中取出数据  转会order对象
            Order order = gson.fromJson(valueByKey, Order.class);
            return order;
        } else {
            throw new OrderNotExit("订单在缓存中不存在，请确认");
        }

    }
*/

    /*@Override
    public Order selectOrder(String tel,int costState) throws OutOfTimeYang {

        Gson gson = new Gson();

        //使用用户的电话+Order组成字符串作为redis的key  保存order信息
        String orderkey=tel+"Order";



        //从缓存中查询是否存在该用户对应的value值
        String valueByKey = red.getValueByKey(orderkey);


        //查询redis 中是否存在当前订单信息如果有查询redis  没有查询数据库
        if (null!= valueByKey && !valueByKey.isEmpty() ){

            //缓存中取出数据  转会order对象
            Order order2=gson.fromJson(valueByKey,Order.class);

            return order2;

        }else{
            synchronized (orderkey){
                //再次查询缓存
                valueByKey =red.getValueByKey(orderkey);

                if (null == valueByKey || valueByKey.equals("")){
                    //查询数据库
                    SqlSession sqlSession = getSqlSession();
                    //获取order对象
                    Order order = sqlSession.selectOne("com.ticket.UserInfo.bean.OrderMapper.selectUserOrder",costState);
                    //对象转json
                    String orderjson = gson.toJson(order);

                    //获取当前系统时间戳
                    long nowtime = System.currentTimeMillis();
                    //获取对象创建时间
                    Date orderTime = order.getOrderTime();
                    //将对象创建时间转化为时间戳
                    long time = orderTime.getTime();


                    Long staytime=time+900000-nowtime;
                    if (staytime>0){
                        //将查找到的订单对象转成json字符串之后存入redis中
                        red.saveStringToSet(orderkey,orderjson,staytime);

                        return order;

                    }else{
                        throw new OutOfTimeYang("订单的创建时间与当前的时间差超过15分钟，应该自动删除该订单");

                    }
                }
                return  null;
            }
        }
    }*/



/**
 *      查询未支付订单的数量  0,查询已支付的订单数量1
 *
 * @return
 */
    @Override
    public int checkOrderNum(int costState) {
        int number = getSqlSession().selectOne("com.ticket.UserInfo.bean.OrderMapper.selectNumberofUnpay", costState);

        return number;
    }




/**
 *  查询历史订单  根据支付状态不为0则为历史订单
 * @param
 *
 * @return
 */
    @Override
    public List<Order> selectHistoryListOrder(int userId) {
        List<Order> historyOrderList = getSqlSession().selectList("com.ticket.UserInfo.bean.OrderMapper.selecthistory",userId);
        return historyOrderList;
    }

    @Override
    public UserBean selectUserByID(int user_id) {
        return getSqlSession().selectOne("com.ticket.UserInfo.bean.UserBeanMapper.selectUserByID",user_id);
    }
}
