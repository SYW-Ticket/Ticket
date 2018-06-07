package com.ticket.film.service;

import com.ticket.film.dao.impl.FilmDao;
import com.ticket.film.entity.FilmDetail;
import com.ticket.film.entity.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wangpeng
 * @Date 2018/6/7
 * @Time 11:08
 */
@Service
public class FilmService {
    @Resource
    private FilmDao filmDao;
//    public PageBean findAllFilmsLoadingByPage(int currentPage){
//        PageBean pageBean = new PageBean();
//        int count = filmDao.selectLoadingCounts();
//        int countPage = count%PageBean.PAGE_SIZE > 0 ? count/PageBean.PAGE_SIZE+1:count/PageBean.PAGE_SIZE;
//        int start = (currentPage-1)*PageBean.PAGE_SIZE;
//        List<FilmDetail> filmDetails = filmDao.filmsLoadingByPage(start);
//        pageBean.setCurrentPage(currentPage);
//        pageBean.setFilmDetails(filmDetails);
//        pageBean.setCountPage(countPage);
//        return pageBean;
//    }
//    public PageBean filmsWillLoadByPage(int currentPage){
//        PageBean pageBean = new PageBean();
//        int count = filmDao.selectWillLoadCounts();
//        int countPage = count%PageBean.PAGE_SIZE > 0 ? count/PageBean.PAGE_SIZE+1:count/PageBean.PAGE_SIZE;
//        int start = (currentPage-1)*PageBean.PAGE_SIZE;
//        List<FilmDetail> filmDetails = filmDao.filmsWillLoadByPage(start);
//        pageBean.setCurrentPage(currentPage);
//        pageBean.setFilmDetails(filmDetails);
//        pageBean.setCountPage(countPage);
//        return pageBean;
//    }

    public List<FilmDetail> allFilmDetailsLoading(){
        return filmDao.filmsLoading();
    }
    public List<FilmDetail> allFilmDetailsWillLoad(){
        return filmDao.filmsWillLoad();
    }
    public FilmDetail filmDetail(int filmId){
        return filmDao.filmDetail(filmId);
    }
}
