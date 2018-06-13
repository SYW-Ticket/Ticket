package com.ticket.seat;

import com.ticket.film.dao.ISeatDao;
import com.ticket.film.dao.impl.IHallDao;
import com.ticket.film.entity.HallBean;
import com.ticket.film.service.SeatService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wangpeng
 * @Date 2018/6/11
 * @Time 12:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class TestSeat {
    @Resource
    private ISeatDao seatDao;
    @Resource
    private IHallDao hallDao;
    @Resource
    private SeatService seatService;
    @Test
    public void testAllSeats(){
//        List<Seat> seats = seatDao.selectAllSeatByHallId(1);
//        for (Seat seat : seats) {
//            System.out.println(seat);
//        }
        HallBean hall = hallDao.selectHallWithID(1);
        System.out.println(hall);
    }
    @Test
    public void testSelectAllSeatOccupiesByPlatoonId(){
        List<Integer> ids = seatDao.selectAllSeatOccupiesByPlatoonId(1);
        for (Integer id : ids) {
            System.out.println(id);
        }
    }
    @Test
    public void selectAllSeatOccupiesBySeatId(){
        int[]seatIds = {3,21,22,23,31};
        System.out.println(seatService.seatsIsBeOccupied(seatIds));
    }
}
