package com.ticket.film.controller;

import com.ticket.film.service.PLatoonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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
    @RequestMapping("/allSeatsByPId/{hallId}")
    public String findAllSeats(@PathVariable("hallId") int PId, Model model){
        model.addAttribute("platoon",pLatoonService.findPlatoonById(PId));
        return "/occupy_seat";
    }
}
