package com.ticket.UserInfo.UserInfoDAO;

import com.ticket.UserInfo.bean.UserBean;

/**
 * Created by Shinelon on 2018/6/6.
 */
public interface IUserInfoDAO {

     //发送验证码
     void sendMessage(String message, String tel);

     //判断短信验证码
     boolean CheckShortMessage(String message,String tel);

     //短信验证码正确  查找密码判断是否相等  与新密码
     UserBean ModifyPasswordFirst(String tel);
     //修改密码

     int ModifyPassword(String tel, String newpassword);


}
