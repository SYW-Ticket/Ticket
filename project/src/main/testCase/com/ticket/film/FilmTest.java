package com.ticket.film;

import com.ticket.film.dao.AreaDao;
import com.ticket.film.dao.PlatoonDao;
import com.ticket.film.dao.impl.FilmDao;
import com.ticket.film.entity.FilmDetail;
import com.ticket.film.entity.PlatoonBean;
import com.ticket.film.service.FilmService;
import com.ticket.insertOrder.bean.Order;
import com.ticket.insertOrder.daoRead.OrderDaoRead;
import com.ticket.loginandregister.redis.Redisimpl.Redisimpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    private Redisimpl redisImpl;


    @Resource
    private AreaDao areaDao;
    @Resource
    private PlatoonDao platoonDao;

    @Resource
    private OrderDaoRead orderDaoRead;

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
    public void film02() throws ParseException {
        String str = "2018-06-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        date = sdf.parse(str);
        HashMap<String,Object> map = new HashMap<>();
        map.put("film_id",1);
        map.put("cinema_id",2);
        map.put("show_start_date",date);
        List<PlatoonBean> platoonBeans = platoonDao.selectAllPlatoonByFilm_id(map);
        System.out.println(platoonBeans);
    }

    @Test
    public void film03(){
       Order order = orderDaoRead.selectOrderByID(1);
        System.out.println(order);
    }
}
