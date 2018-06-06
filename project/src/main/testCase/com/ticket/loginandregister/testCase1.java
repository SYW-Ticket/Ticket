package com.ticket.loginandregister;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Shinelon on 2018/6/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class testCase1 {

    @Autowired
    private SqlSessionFactory sqlSessionFactoryWrite;


    @Test
    public void testCase1(){

        SqlSession sqlSession = sqlSessionFactoryWrite.openSession();

        sqlSession.insert("com.ticket.loginandregister.bean.UserBeanMapper.insertUser");


    }

}
