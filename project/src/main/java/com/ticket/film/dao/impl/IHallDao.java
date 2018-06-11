package com.ticket.film.dao.impl;

import com.ticket.film.dao.HallDao;
import com.ticket.film.entity.HallBean;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository
public class IHallDao extends SqlSessionDaoSupport implements HallDao {

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactoryRead) {
        super.setSqlSessionFactory(sqlSessionFactoryRead);
    }

    @Override
    public HallBean selectHallWithID(int hall_id) {
        SqlSession sqlSession = getSqlSession();
        return sqlSession.selectOne("com.ticket.film.dao.HallDao.selectHallWithID",hall_id);
    }
}
