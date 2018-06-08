package com.ticket.film.dao;

import com.ticket.film.entity.PlatoonBean;

import java.util.List;

public interface PlatoonDao {
    List<PlatoonBean> selectAllPlatoonByFilm_id(int film_id);
}
