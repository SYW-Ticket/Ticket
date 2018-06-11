package com.ticket.film.controller;

import com.ticket.film.entity.PlatoonBean;
import com.ticket.film.service.PLatoonService;
import com.ticket.film.service.SeatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wangpeng
 * @Date 2018/6/11
 * @Time 13:59
 */

@Controller
@RequestMapping("/seat")
public class SeatController {
    @Resource
    private PLatoonService pLatoonService;
    @Resource
    private SeatService seatService;
    @RequestMapping("/allSeatsByPId/{platoonId}")
    public String findAllSeats( @PathVariable("platoonId") int PId,Model model){
        PlatoonBean platoon = pLatoonService.findPlatoonById(PId);
        List<Integer> seatsOccupiedIds = seatService.selectAllSeatOccupiesByPlatoonId(PId);
        model.addAttribute("platoon",platoon);
        model.addAttribute("seatsOccupiedIds",seatsOccupiedIds);
        return "/occupy_seat";
    }
}
