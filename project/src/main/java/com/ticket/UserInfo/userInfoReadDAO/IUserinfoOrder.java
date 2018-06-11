package com.ticket.UserInfo.userInfoReadDAO;

import com.ticket.UserInfo.bean.Order;
import com.ticket.UserInfo.util.MyselfException.OrderNotExit;
import com.ticket.UserInfo.util.MyselfException.OutOfTimeYang;

import java.util.List;

/**
 * Created by Shinelon on 2018/6/8.
 */
public interface IUserinfoOrder {


    //查询订单 by tel
    Order selectOrder(int platoonId,int costState,int seatId) throws OutOfTimeYang, OrderNotExit;

    //显示订单的数量
    int checkOrderNum(int costState);


    //查询历史订单
    List<Order> selectHistoryListOrder(String nowtime);

}
