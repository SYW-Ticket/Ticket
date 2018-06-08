package com.ticket.film;

import com.ticket.film.dao.impl.FilmDao;
import com.ticket.film.entity.FilmDetail;
import com.ticket.film.service.FilmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wangpeng
 * @Date 2018/6/7
 * @Time 10:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class FilmTest {
    @Resource
    private FilmDao filmDao;
    @Resource
    private FilmService filmService;


    @Test
    public void filmsLoading(){
        List<FilmDetail> filmDetails= filmDao.filmsLoading();
        for (FilmDetail filmDetail : filmDetails) {
            System.out.println(filmDetail);
        }
    }
//    @Test
//    public void filmsLoadingByPage(){
//        List<FilmDetail> filmDetails= filmDao.filmsLoadingByPage(0);
//        for (FilmDetail filmDetail : filmDetails) {
//            System.out.println(filmDetail);
//        }
//    }
//    @Test
//    public void loadingFilmCounts(){
//        System.out.println(filmDao.selectLoadingCounts());
//    }

    /*
    测试FilmService的缓存查询
     */
    @Test
    public void filmServiceLoading(){
        List<FilmDetail> filmDetails = filmService.allFilmDetailsLoading();
        for (FilmDetail filmDetail : filmDetails) {
            System.out.println(filmDetail);
        }
    }
    @Test
    public void filmServiceWillLoad(){
        List<FilmDetail> filmDetails = filmService.allFilmDetailsWillLoad();
        for (FilmDetail filmDetail : filmDetails) {
            System.out.println(filmDetail);
        }
    }
    @Test
    public void filmDetailService(){
        FilmDetail filmDetail = filmService.filmDetail(1);
        System.out.println(filmDetail);
    }
}
