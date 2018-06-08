package com.ticket.film.dao;

import com.ticket.film.entity.AreaBean;

import java.util.List;

public interface AreaDao {
    //查询所有地区
    List<AreaBean> findAllArea();
}
