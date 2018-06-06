package com.film.dao.impl;

import com.film.dao.IFilmDao;
import com.film.entity.Film;
import com.film.entity.FilmDetail;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wangpeng
 * @Date 2018/6/6
 * @Time 17:00
 */
@Repository
public class FilmDao extends SqlSessionDaoSupport implements IFilmDao {
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactoryRead) {
        System.out.println("12111111111111111");
        super.setSqlSessionFactory(sqlSessionFactoryRead);
    }

    @Override
    public List<Film> filmsLoading() {
        return null;
    }

    @Override
    public List<Film> filmsWillLoad() {
        return null;
    }

    @Override
    public List<Film> filmsLoadingByPage(int currentPage) {
        return null;
    }

    @Override
    public List<Film> filmsWillLoadByPage(int currentPage) {
        return null;
    }

    @Override
    public FilmDetail filmDetail(int filmId) {
        SqlSession sqlSession = getSqlSession();
        return sqlSession.selectOne("com.film.dao.IFilmDao.filmDetail",filmId);
    }


}
