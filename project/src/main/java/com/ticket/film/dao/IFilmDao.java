package com.film.dao;

import com.film.entity.Film;
import com.film.entity.FilmDetail;

import java.util.List;

/**
 * @Author wangpeng
 * @Date 2018/6/6
 * @Time 14:28
 *
 */
public interface IFilmDao {
    //查询所有正在上映的电影
    List<Film> filmsLoading();

    //查找所有即将上映的电影
    List<Film> filmsWillLoad();

    //分页查找正在上映的电影
    List<Film> filmsLoadingByPage(int currentPage);

    //分页查找即将上映的电影
    List<Film> filmsWillLoadByPage(int currentPage);

    //查看电影详情
    FilmDetail filmDetail(int filmId);
}
