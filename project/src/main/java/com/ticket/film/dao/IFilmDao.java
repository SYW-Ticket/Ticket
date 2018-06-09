package com.ticket.film.dao;

import com.ticket.film.entity.Actor;
import com.ticket.film.entity.Film;
import com.ticket.film.entity.FilmDetail;

import java.util.Date;
import java.util.List;

/**
 * @Author wangpeng
 * @Date 2018/6/6
 * @Time 14:28
 *
 */
public interface IFilmDao {
    //查询所有正在上映的电影
    List<FilmDetail> filmsLoading();

    //查找所有即将上映的电影
    List<FilmDetail> filmsWillLoad();

//    //分页查找正在上映的电影
//    List<FilmDetail> filmsLoadingByPage(int currentPage);
//
//    //分页查找即将上映的电影
//    List<FilmDetail> filmsWillLoadByPage(int currentPage);

    //查看电影详情

    FilmDetail filmDetail(int filmId);
//    //查找上映中的电影总数
//    int selectLoadingCounts();
//    //查找即将上映的电影总数
//    int selectWillLoadCounts();

    List<FilmDetail> test();
}
