package com.ticket.film.dao.impl;

import com.ticket.film.dao.AreaDao;
import com.ticket.film.entity.AreaBean;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IAreaDao extends SqlSessionDaoSupport implements AreaDao{

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactoryRead) {
        super.setSqlSessionFactory(sqlSessionFactoryRead);
    }

    @Override
    public List<AreaBean> findAllArea() {
        SqlSession sqlSession = getSqlSession();
        return sqlSession.selectList("com.ticket.film.dao.AreaDao.selectAllArea");
    }
}
