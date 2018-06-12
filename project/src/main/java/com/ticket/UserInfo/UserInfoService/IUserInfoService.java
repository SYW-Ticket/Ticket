package com.ticket.UserInfo.UserInfoService;

import com.ticket.UserInfo.bean.Order;
import com.ticket.UserInfo.util.MyselfException.EqualsException;
import com.ticket.UserInfo.util.MyselfException.YangException;

import java.util.List;

/**
 * Created by Shinelon on 2018/6/6.
 */
public interface IUserInfoService {
    //发送短信
    void sendMessage(String pwd,String tel);
    //检查短信验证码
    void CheckMessage(String ShortMessage,String tel) throws YangException;
    //修改密码
    void ModifyPasswordService(String tel,String newpassword) throws EqualsException;



    //查找订单未支付的订单 ，
    // 根据支付状态来判断  0 未支付  1 已经支付 并且订单未支付的只能存在一个，出现下一个上一个未支付订单自动删除
    // 超过支付时间
    Order findUnPayOrder(int userId);

    void deleteOrder(int id);

    //查询历史订单
    List<Order> HistoryorderList(int userId);
}
