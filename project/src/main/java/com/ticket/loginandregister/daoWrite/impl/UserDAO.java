package com.ticket.loginandregister.daoWrite.impl;

import com.ticket.loginandregister.daoWrite.IUserDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Shinelon on 2018/6/6.
 */
@Repository
public class UserDAO extends SqlSessionDaoSupport implements IUserDAO {
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactoryWrite) {

        super.setSqlSessionFactory(sqlSessionFactoryWrite);
    }


    @Override
    public void InsertUser() {

        SqlSession sqlSession = getSqlSession();
        int insert = sqlSession.insert("com.ticket.loginandregister.bean.UserBeanMapper.insertUser");
        System.out.println(insert);

    }
}
