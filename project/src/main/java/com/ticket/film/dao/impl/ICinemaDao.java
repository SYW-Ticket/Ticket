package com.ticket.film.dao.impl;

import com.ticket.film.dao.CinemaDao;
import com.ticket.film.entity.CinemaBean;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public class ICinemaDao extends SqlSessionDaoSupport implements CinemaDao {
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactoryRead) {
        super.setSqlSessionFactory(sqlSessionFactoryRead);
    }

    @Override
    public List<CinemaBean> findcinmeByAreaId(int area_id) {
        SqlSession sqlSession = getSqlSession();
        return sqlSession.selectList("com.ticket.film.dao.CinemaDao.findcinmeByAreaId",area_id);
    }
}
