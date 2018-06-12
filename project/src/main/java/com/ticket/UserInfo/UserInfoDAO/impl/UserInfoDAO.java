package com.ticket.UserInfo.UserInfoDAO.impl;

import com.ticket.UserInfo.UserInfoDAO.IUserInfoDAO;
import com.ticket.UserInfo.bean.Order;
import com.ticket.UserInfo.bean.UserBean;
import com.ticket.UserInfo.redis.IRedis;
import com.ticket.UserInfo.util.Message.MessageTool;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Shinelon on 2018/6/6.
 */
@Repository
public class UserInfoDAO extends SqlSessionDaoSupport implements IUserInfoDAO {
    @Autowired
    private IRedis red;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactoryWrite) {
        super.setSqlSessionFactory(sqlSessionFactoryWrite);
    }


    /**
     *   发送短信验证码
     * @return
     */
    @Override
    public void sendMessage(String message, String tel) {
        MessageTool.send(message,tel);
    }







    /**
     *   当短信验证码正确  则根据电话号查找密码并比对新密码是否与旧密码相同
     * @param tel
     * @return
     */
    @Override
    public UserBean ModifyPasswordFirst(String tel) {
        SqlSession sqlSession = getSqlSession();

        UserBean user = sqlSession.selectOne("com.ticket.UserInfo.bean.UserBeanMapper.selectUserPassword",tel);

        return user;
    }




    /**
     *  短信验证码验证方法
     *  by  杨国帅   at  2018/6/6  16：17
     * @param message 输入的字符串
     * @return 返回验证结果  boolean
     */
    @Override
    public boolean CheckShortMessage(String message,String tel) {

        //根据tel  查找redis中的信息
        String valueByKey = red.getValueByKey(tel);

        //如果redis中不存在该验证码  或者验证码不匹配返回false
        if ( valueByKey==null || !valueByKey.equals(message)){
            return false;
        }
        return true;
    }

    /**
     *   当新密码与旧密码不相等时  进行修改
     * @param tel
     * @param newpassword
     * @return
     */
    @Override
    public int ModifyPassword(String tel, String newpassword) {
        UserBean userBean = new UserBean();
        userBean.setTel(tel);
        userBean.setPassword(newpassword);
        int update = getSqlSession().update("com.ticket.UserInfo.bean.UserBeanMapper.updateUserpassword", userBean);


        return update;
    }



    //***********************************订单的方法****************************************************************************
    //********************************************************************************************************************************

    /**
     *      订单删除方法
     * @param id
     * @return
     */
    @Override
    public int deleteOrderById(int id,int costState) {

        Order order = new Order();
        order.setCostState(costState);
        order.setId(id);
        int flag = getSqlSession().delete("com.ticket.UserInfo.bean.OrderMapper.deleteOrderById",order);

        return flag;
    }





}































