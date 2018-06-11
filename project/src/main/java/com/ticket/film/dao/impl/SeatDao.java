package com.ticket.film.dao.impl;

import com.ticket.film.dao.ISeatDao;
import com.ticket.film.entity.Seat;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author wangpeng
 * @Date 2018/6/11
 * @Time 11:42
 */
@Repository
public class SeatDao extends SqlSessionDaoSupport implements ISeatDao {
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactoryRead) {
        super.setSqlSessionFactory(sqlSessionFactoryRead);
    }
    @Override
    public List<Seat> selectAllSeatByHallId(int hallId) {
        return getSqlSession().selectList("com.ticket.seat.dao.ISeatDao.selectAllSeatByHallId",hallId);
    }
}