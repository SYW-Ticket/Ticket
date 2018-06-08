package com.ticket.film.controller;


import com.ticket.film.entity.CinemaBean;
import com.ticket.film.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/cinema")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;


    @ResponseBody
    @RequestMapping("/findCinema")
    public Object findCinema(String areaid, Model model){
        List<CinemaBean> cinemas= cinemaService.findCinema(Integer.parseInt(areaid));
        return cinemas;
    }


}
