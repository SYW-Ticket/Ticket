package com.ticket.film.dao;


import com.ticket.film.entity.Seat;

import java.util.List;

/**
 * @Author wangpeng
 * @Date 2018/6/11
 * @Time 11:41
 */
public interface ISeatDao {
    List<Seat> selectAllSeatByHallId(int hallId);
    List<Integer> selectAllSeatOccupiesByPlatoonId(int platoonId);
    List<Seat> selectAllSeatByOrderID(int order_id);
    List<Integer> selectAllSeatOccupiesBySeatId(int[]seatIds);
}
