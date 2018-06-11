package com.ticket.film.service;

import com.ticket.film.dao.ISeatDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wangpeng
 * @Date 2018/6/11
 * @Time 18:59
 */
@Service
public class SeatService {
    @Resource
    private ISeatDao seatDao;
    public List<Integer> selectAllSeatOccupiesByPlatoonId(int PId){
        return seatDao.selectAllSeatOccupiesByPlatoonId(PId);
    }
}
