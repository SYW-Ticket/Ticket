package com.ticket.film.dao;

import com.ticket.film.entity.PlatoonBean;

import java.util.List;
import java.util.Map;

public interface PlatoonDao {
    List<PlatoonBean> selectAllPlatoonByFilm_id(Map<String,Integer> map);
}
