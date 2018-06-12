package com.ticket.UserInfo.userInfoReadDAO;

import com.ticket.UserInfo.bean.Order;
import com.ticket.UserInfo.bean.UserBean;

import java.util.List;

/**
 * Created by Shinelon on 2018/6/8.
 */
public interface IUserinfoOrder {


   /* //查询订单 by tel
    Order selectOrder(int userId,int costState) throws OutOfTimeYang, OrderNotExit;*/

    //显示订单的数量
    int checkOrderNum(int costState);


    //查询历史订单
    List<Order> selectHistoryListOrder(int userId);

    UserBean selectUserByID(int user_id);
}
