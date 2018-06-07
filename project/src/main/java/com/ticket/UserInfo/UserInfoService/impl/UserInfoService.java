package com.ticket.UserInfo.UserInfoService.impl;

import com.ticket.UserInfo.UserInfoDAO.IUserInfoDAO;
import com.ticket.UserInfo.UserInfoService.IUserInfoService;
import com.ticket.UserInfo.bean.UserBean;
import com.ticket.UserInfo.util.MyselfException.EqualsException;
import com.ticket.UserInfo.util.MyselfException.YangException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shinelon on 2018/6/6.
 */
@Service
public class UserInfoService implements IUserInfoService {

    //用于写操作的数据库的userDAO
    @Autowired
    private IUserInfoDAO userInfoDAO;




    /**
     *  用于获得UserInfoDAO的boolean   此方法是透传
     * @param ShortMessage
     * @return
     */
    @Override
    public void CheckMessage(String ShortMessage,String tel) throws YangException {
        boolean flag = userInfoDAO.CheckShortMessage(ShortMessage,tel);
        if (!flag){
            throw new YangException("比对失败");
        }
    }


    /**
     * 修改密码时先查一次
     * @param tel
     */
    @Override
    public void ModifyPasswordService(String tel,String newpassword) throws EqualsException {

        UserBean userBean = userInfoDAO.ModifyPasswordFirst(tel);

        String password = userBean.getPassword();

        if (password.equals(newpassword)){
            throw new EqualsException("新旧密码相同");
        }else{
            //如果密码不等  则调用修改方法
            int row = userInfoDAO.ModifyPassword(tel, newpassword);
            System.out.println(row);
        }

    }


}
