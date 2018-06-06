package com.ticket.loginandregister.daoWrite.impl;

import com.ticket.loginandregister.bean.UserBean;
import com.ticket.loginandregister.daoWrite.IUserDAOWrite;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Shinelon on 2018/6/6.
 */
@Repository
public class UserDAOWrite extends SqlSessionDaoSupport implements IUserDAOWrite {
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactoryWrite) {
        super.setSqlSessionFactory(sqlSessionFactoryWrite);
    }


    @Override
    public void insertUserWithTel(UserBean userBean) {
        SqlSession sqlSession = getSqlSession();
        sqlSession.insert("com.ticket.loginandregister.bean.UserBeanMapper.insertUserWithTel",userBean);
    }
}
