package com.ticket.loginandregister.DAO.impl;

import com.ticket.loginandregister.DAO.IUserDAO;
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
public class UserDAO extends SqlSessionDaoSupport implements IUserDAO {
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactoryWrite) {
        System.out.println("12111111111111111");
        super.setSqlSessionFactory(sqlSessionFactoryWrite);
    }


    @Override
    public void InsertUser() {

        SqlSession sqlSession = getSqlSession();
        int insert = sqlSession.insert("com.ticket.loginandregister.bean.UserBeanMapper.insertUser");
        System.out.println(insert);

    }

    @Override
    public void selectUser() {
        SqlSession sqlSession = getSqlSession();
        UserBean o = sqlSession.selectOne("com.ticket.loginandregister.bean.UserBeanMapper.selectUser");
        System.out.println(o.getAcount());

    }
}
