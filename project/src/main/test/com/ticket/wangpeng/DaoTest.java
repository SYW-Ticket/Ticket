package com.ticket.wangpeng;

import com.ticket.film.dao.impl.FilmDao;
import com.ticket.film.entity.Actor;
import com.ticket.film.entity.Film;
import com.ticket.film.entity.FilmDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author wangpeng
 * @Date 2018/6/6
 * @Time 17:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class DaoTest {
    @Resource
    private FilmDao filmDao;
    @Test
    public void filmDetails(){
        FilmDetail filmDetail = filmDao.filmDetail(1);
        System.out.println(filmDetail);
    }

    @Test
    public void filmsLoading(){
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date();
//        df.format(date);
        List<FilmDetail> films = filmDao.filmsLoading();
        for (FilmDetail film : films) {
            System.out.println(film);
        }
//        List<FilmDetail> films = filmDao.filmsWillLoad();
//        for (FilmDetail film : films) {
//            System.out.println(film);
//        }
    }
    @Test
    public void filmsLoadingByPage(){
        List<FilmDetail> films = filmDao.filmsLoadingByPage(1);
        for (FilmDetail film : films) {
            System.out.println(film);
        }
    }
}
