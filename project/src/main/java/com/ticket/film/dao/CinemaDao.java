package com.ticket.film.dao;

import com.ticket.film.entity.CinemaBean;

import java.util.List;

public interface CinemaDao {
    public List<CinemaBean> findcinmeByAreaId(int area_id);
}
