package com.ticket.film;

import com.ticket.film.dao.impl.FilmDao;
import com.ticket.film.entity.FilmDetail;
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
    @Test
    public void filmsLoading(){
        List<FilmDetail> filmDetails= filmDao.filmsLoading();
        for (FilmDetail filmDetail : filmDetails) {
            System.out.println(filmDetail);
        }
    }
}
