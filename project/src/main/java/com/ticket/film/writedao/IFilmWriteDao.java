package com.ticket.film.writedao;

/**
 * @Author wangpeng
 * @Date 2018/6/8
 * @Time 16:05
 */
public interface IFilmWriteDao {
    //更新电影hot值
    void updateFilmHot(int filmId,int hotValue);
    //查找电影hot值
    int selectFilmHot(int filmId);
}
