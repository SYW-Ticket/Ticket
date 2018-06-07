package com.ticket.UserInfo.UserInfoService;

import com.ticket.UserInfo.util.MyselfException.EqualsException;
import com.ticket.UserInfo.util.MyselfException.YangException;

/**
 * Created by Shinelon on 2018/6/6.
 */
public interface IUserInfoService {
    void sendMessage(String pwd,String tel);

    void CheckMessage(String ShortMessage,String tel) throws YangException;

    void ModifyPasswordService(String tel,String newpassword) throws EqualsException;
}
