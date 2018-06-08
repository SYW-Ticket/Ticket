package com.ticket.UserInfo.userInfoReadDAO.impl;


import com.ticket.UserInfo.bean.Order;
import com.ticket.UserInfo.redis.IRedis;
import com.ticket.UserInfo.userInfoReadDAO.IUserinfoOrder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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


    /**
     *   此方法是订单表查询
     * @param costState
     */
    @Override
    public void selectOrder(int tel,int costState) {

        //使用用户的电话+Order组成字符串作为redis的key  保存order信息
        String a=tel+"Order";




        //查询redis 中是否存在当前订单信息如果有查询redis  没有查询数据库
        if (null==red){
            SqlSession sqlSession = getSqlSession();


            Order order = sqlSession.selectOne("com.ticket.UserInfo.bean.OrderMapper.selectUserOrder",costState);

        }


    }
}
