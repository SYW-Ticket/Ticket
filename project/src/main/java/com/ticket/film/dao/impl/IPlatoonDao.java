package com.ticket.film.dao.impl;

import com.ticket.film.dao.PlatoonDao;
import com.ticket.film.entity.PlatoonBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class IPlatoonDao extends SqlSessionDaoSupport implements PlatoonDao{

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactoryRead) {
        super.setSqlSessionFactory(sqlSessionFactoryRead);
    }

    @Override
    public List<PlatoonBean> selectAllPlatoonByFilm_id(Map<String,Integer> map) {
        SqlSession sqlSession = getSqlSession();
        return sqlSession.selectList("com.ticket.film.dao.PlatoonDao.selectAllPlatoonByFilm_id",map);
    }
}
