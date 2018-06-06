package com.ticket.loginandregister.DAORead.impl;

import com.ticket.loginandregister.DAORead.IUserDAORead;
import com.ticket.loginandregister.bean.UserBean;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Shinelon on 2018/6/6.
 */
@Repository
public class UserRead extends SqlSessionDaoSupport implements IUserDAORead {
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactoryRead) {

        super.setSqlSessionFactory(sqlSessionFactoryRead);
    }


    @Override
    public void selectUser() {
        SqlSession sqlSession = getSqlSession();


        UserBean selectOne = sqlSession.selectOne("com.ticket.loginandregister.bean.UserBeanMapper.selectUser");

        System.out.println("22222222222222222222222"+selectOne.getMoney());


    }
}
