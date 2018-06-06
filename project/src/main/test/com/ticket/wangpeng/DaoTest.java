package com.ticket.wangpeng;

import com.ticket.film.dao.impl.FilmDao;
import com.ticket.film.entity.Actor;
import com.ticket.film.entity.FilmDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
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
}
