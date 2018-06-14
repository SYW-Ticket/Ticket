package com.ticket.UserInfo.UserInfoService.impl;

import com.google.gson.Gson;
import com.ticket.UserInfo.UserInfoDAO.IUserInfoDAO;
import com.ticket.UserInfo.UserInfoService.IUserInfoService;
import com.ticket.UserInfo.UserInfoService.deleteService.RemoveJob;
import com.ticket.UserInfo.bean.Order;
import com.ticket.UserInfo.bean.UserBean;
import com.ticket.UserInfo.redis.IRedis;
import com.ticket.UserInfo.userInfoReadDAO.IUserinfoOrder;
import com.ticket.UserInfo.util.MyselfException.EqualsException;
import com.ticket.UserInfo.util.MyselfException.YangException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shinelon on 2018/6/6.
 */
@Service
public class UserInfoService implements IUserInfoService {

    @Autowired
    private IUserInfoDAO userInfoDAO;
    @Autowired
    private IUserinfoOrder userinfoOrder;
    @Autowired
    private IRedis red;
    @Autowired
    private RemoveJob removeJob;
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

        if (userBean.getPassword()!=null&&newpassword.equals(userBean.getPassword())){
            throw new EqualsException("新旧密码相同");
        }else{
            //如果密码不等  则调用修改方法
            int row = userInfoDAO.ModifyPassword(tel, newpassword);
            System.out.println(row);
        }

    }

    /**
     *     在redis 中查找订单  存在则未支付 使用userId查找
     *
     */
    @Override
    public com.ticket.insertOrder.bean.Order findUnPayOrder(int userId){


        String s = "order_"+Integer.toString(userId);

        String valueByKey = red.getValueByKey(s);

        Gson gson = new Gson();
        int flag2=1;
        if (null != valueByKey && !valueByKey.isEmpty()) {
            //缓存中取出数据  转会order对象
            com.ticket.insertOrder.bean.Order order = gson.fromJson(valueByKey,com.ticket.insertOrder.bean.Order.class);

            return order;
        } else {
        return  null;
    }

    }

    /**
     *
     *  删除历史订单  修改支付状态为3
     * @param id
     */
    @Override
    public void deleteOrder(int id) {

        removeJob.testremoveJob(id);
    }


    /**
     *   查询历史订单
     * @return
     */
    @Override
    public List<Order> HistoryorderList(int userId) {
        List<Order> orders = userinfoOrder.selectHistoryListOrder(userId);

        return orders;
    }


}
