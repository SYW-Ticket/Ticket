package com.ticket.insertOrder.daoRead.ImplDaoRead;

import com.ticket.insertOrder.bean.Order;
import com.ticket.insertOrder.daoRead.OrderDaoRead;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImplOrderDaoRead extends SqlSessionDaoSupport implements OrderDaoRead{
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactoryRead) {
        super.setSqlSessionFactory(sqlSessionFactoryRead);
    }

    @Override
    public Order selectOrderByID(int id) {
        return getSqlSession().selectOne("com.ticket.insertOrder.daoWrite.OrderDao.selectOrderByID",id);
    }
}
