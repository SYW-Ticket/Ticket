package com.ticket.film;

import com.ticket.film.dao.AreaDao;
import com.ticket.film.dao.PlatoonDao;
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
    @Resource
    private AreaDao areaDao;
    @Resource
    private PlatoonDao platoonDao;

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

    @Test
    public void filmService(){
        List<FilmDetail> filmDetails = filmService.allFilmDetailsLoading();
        for (FilmDetail filmDetail : filmDetails) {
            System.out.println(filmDetail);
        }
    }

    @Test
    public void filmDao(){
        System.out.println(areaDao.findAllArea().get(0).getArea_name());
    }
    @Test
    public void filmDao2(){
        System.out.println(platoonDao.selectAllPlatoonByFilm_id(1).get(0).getId());
    }
}
