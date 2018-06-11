package com.ticket.film.dao;

import com.ticket.film.entity.HallBean;

public interface HallDao {

    public HallBean selectHallWithID(int hall_id);
}
