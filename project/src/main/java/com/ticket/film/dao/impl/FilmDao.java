package com.ticket.film.dao.impl;

import com.ticket.film.dao.IFilmDao;
import com.ticket.film.entity.Actor;
import com.ticket.film.entity.Film;
import com.ticket.film.entity.FilmDetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wangpeng
 * @Date 2018/6/6
 * @Time 17:00
 */
@Repository
public class FilmDao extends SqlSessionDaoSupport implements IFilmDao {
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactoryRead) {
        super.setSqlSessionFactory(sqlSessionFactoryRead);
    }

    @Override
    public List<FilmDetail> filmsLoading() {
        SqlSession sqlSession = getSqlSession();
        return sqlSession.selectList("com.ticket.film.dao.IFilmDao.filmsLoading",new Date());
    }

    @Override
    public List<FilmDetail> filmsWillLoad() {
        SqlSession sqlSession = getSqlSession();
        return sqlSession.selectList("com.ticket.film.dao.IFilmDao.filmsWillLoad",new Date());
    }
    @Override
    public FilmDetail filmDetail(int filmId) {
        SqlSession sqlSession = getSqlSession();
        return sqlSession.selectOne("com.ticket.film.dao.IFilmDao.filmDetail",filmId);
    }

    public List<FilmDetail> test(){
        SqlSession sqlSession = getSqlSession();
        return sqlSession.selectList("com.ticket.film.dao.IFilmDao.test");
    }
//    @Override
//    public List<FilmDetail> filmsLoadingByPage(int start) {
//        SqlSession sqlSession = getSqlSession();
//        Date now = new Date();
//        Map<String,Object> params = new HashMap();
//        params.put("now",now);
//        params.put("start",start);
//        return sqlSession.selectList("com.ticket.film.dao.IFilmDao.filmsLoadingByPage",params);
//    }
//
//    @Override
//    public List<FilmDetail> filmsWillLoadByPage(int start) {
//        SqlSession sqlSession = getSqlSession();
//        Date now = new Date();
//        Map<String,Object> params = new HashMap();
//        params.put("now",now);
//        params.put("start",start);
//        return sqlSession.selectList("com.ticket.film.dao.IFilmDao.filmsWillLoadByPage",params);
//    }

//    @Override
//    public int selectLoadingCounts() {
//        Date now = new Date();
//        return getSqlSession().selectOne("com.ticket.film.dao.IFilmDao.selectLoadingCounts",now);
//    }
//
//    @Override
//    public int selectWillLoadCounts() {
//        return getSqlSession().selectOne("com.ticket.film.dao.IFilmDao.selectWillLoadCounts",new Date());
//    }

}
