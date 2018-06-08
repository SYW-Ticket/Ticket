package com.ticket.film.writedao.impl;

import com.ticket.film.writedao.IFilmWriteDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangpeng
 * @Date 2018/6/8
 * @Time 16:13
 */
@Repository
public class FilmWriteDao extends SqlSessionDaoSupport implements IFilmWriteDao{
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactoryWrite) {
        super.setSqlSessionFactory(sqlSessionFactoryWrite);
    }

    @Override
    public void updateFilmHot(int filmId, int hotValue) {
        Map<String,Object> params = new HashMap<>();
        params.put("hotValue",hotValue);
        params.put("filmId",filmId);
        getSqlSession().update("com.ticket.film.dao.IFilmDao.updateFilmHot",params);
    }

    @Override
    public int selectFilmHot(int filmId) {
        return getSqlSession().selectOne("com.ticket.film.dao.IFilmDao.selectFilmHot",filmId);
    }
}
