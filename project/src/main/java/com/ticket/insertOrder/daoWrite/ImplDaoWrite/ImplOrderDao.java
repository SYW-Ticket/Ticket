package com.ticket.insertOrder.daoWrite.ImplDaoWrite;

import com.ticket.insertOrder.bean.Order;
import com.ticket.insertOrder.daoWrite.OrderDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ImplOrderDao extends SqlSessionDaoSupport implements OrderDao{
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactoryWrite) {
        super.setSqlSessionFactory(sqlSessionFactoryWrite);
    }

    @Override
    public void insertOrder(Order order) {
        SqlSession sqlSession = getSqlSession();
        sqlSession.insert("com.ticket.insertOrder.daoWrite.OrderDao.insertOrder",order);
    }
}
