package com.ticket.UserInfo.UserInfoService.impl;

import com.ticket.UserInfo.UserInfoDAO.IUserInfoDAO;
import com.ticket.UserInfo.UserInfoService.IUserInfoService;
import com.ticket.UserInfo.bean.Order;
import com.ticket.UserInfo.bean.UserBean;
import com.ticket.UserInfo.userInfoReadDAO.IUserinfoOrder;
import com.ticket.UserInfo.util.MyselfException.EqualsException;
import com.ticket.UserInfo.util.MyselfException.OutOfTimeYang;
import com.ticket.UserInfo.util.MyselfException.YangException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Shinelon on 2018/6/6.
 */
@Service
public class UserInfoService implements IUserInfoService {

    @Autowired
    private IUserInfoDAO userInfoDAO;
    @Autowired
    private IUserinfoOrder userinfoOrder;

    /**
     *    发送短信验证码功能
     * @param pwd   短信内容
     * @param tel   电话号码
     */
    @Override
    public void sendMessage(String pwd, String tel) {
        userInfoDAO.sendMessage(pwd,tel);
    }

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

    /**
     *      查询未支付订单   超时删除  新增删除
     * @param costState
     */
    @Override
    public void findUnPayOrder(String tel,int costState){

        try {

            Order order = userinfoOrder.selectOrder(tel, costState);

            //获取当前系统时间戳
            long nowtime = System.currentTimeMillis();
            //获取对象创建时间
            Date orderTime = order.getOrderTime();
            //将对象创建时间转化为时间戳 加15分钟
            long time = orderTime.getTime()+900000;
            Long staytime=time-nowtime;








        } catch (OutOfTimeYang outOfTimeYang) {
            outOfTimeYang.printStackTrace();
        }

    }


}
