package com.ticket.film.service;

import com.ticket.film.dao.ISeatDao;
import org.apache.commons.lang.ArrayUtils;
import org.eclipse.jetty.util.ArrayUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
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
    //筛选用户选中的座位，返回是否有被占座
    public Boolean seatsIsBeOccupied(int[]seatIds){
        Integer[] is = ArrayUtils.toObject(seatIds);
        List<Integer> seatsChoosed = Arrays.asList(is);
        List<Integer> seatsOccupied = seatDao.selectAllSeatOccupiesBySeatId(seatIds);
        for (int seatId : seatsChoosed) {
            if(seatsOccupied.contains(seatId)){
                return true;
            }
        }
        return false;
    }
}
