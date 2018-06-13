package com.ticket.insertOrder.daoWrite.ImplDaoWrite;

import com.ticket.insertOrder.bean.Seat_Occupied;
import com.ticket.insertOrder.daoWrite.Seat_occupiedDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImplSeat_occupiedDao extends SqlSessionDaoSupport implements Seat_occupiedDao {
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactoryWrite) {
        super.setSqlSessionFactory(sqlSessionFactoryWrite);
    }


    @Override
    public void insertSeat_occupiedDao(Seat_Occupied seat_occupied) {
        SqlSession sqlSession = getSqlSession();
        sqlSession.insert("com.ticket.insertOrder.daoWrite.Seat_occupiedDao.insertSeat_occupied",seat_occupied);
    }

    @Override
    public void update_occupiedByOrderID(int order_id) {
        getSqlSession().update("com.ticket.insertOrder.daoWrite.Seat_occupiedDao.update_occupiedByOrderID",order_id);
    }
}
