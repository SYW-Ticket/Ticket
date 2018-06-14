package com.ticket.film.dao.impl;

import com.ticket.film.dao.ISeatDao;
import com.ticket.film.entity.Seat;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Integer> selectAllSeatOccupiesByPlatoonId(int platoonId) {
        return getSqlSession().selectList("com.ticket.seat.dao.ISeatDao.selectAllSeatOccupiesByPlatoonId",platoonId);
    }

    @Override
    public List<Seat> selectAllSeatByOrderID(int order_id) {
        return getSqlSession().selectList("com.ticket.seat.dao.ISeatDao.selectAllSeatByOrderID",order_id);
    }

    @Override
    //where in（）查询所有排片对应的座位
    public List<Integer> selectAllSeatOccupiesBySeatId(int[] seatIds,int PId) {
        Map map = new HashMap();
        map.put("array",seatIds);
        map.put("platoonId",PId);
        return getSqlSession().selectList("com.ticket.seat.dao.ISeatDao.selectAllSeatOccupiesBySeatId",map);
    }
}
