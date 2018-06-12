package com.ticket.film.controller;

import com.ticket.film.entity.CinemaBean;
import com.ticket.film.entity.PlatoonBean;
import com.ticket.film.service.CinemaService;
import com.ticket.film.service.PLatoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping(value = "/cinema")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private PLatoonService pLatoonService;

    @ResponseBody
    @RequestMapping("/findCinema")
    public Object findCinema(@RequestParam("areaid") String areaId){
        List<CinemaBean> cinemas= cinemaService.findCinema(Integer.parseInt(areaId));
        return cinemas;
    }

    @ResponseBody
    @RequestMapping("/findCinemaById")
    public Object findCinemaById(String id){
        CinemaBean cinema= cinemaService.findCinemaByid(Integer.parseInt(id));
        return cinema;
    }

    @ResponseBody
    @RequestMapping("/findPlatoon")
    public Object findPlatoon(@RequestParam("film_id") String film_id, @RequestParam("cinema_id") String cinema_id, @RequestParam("show_start_date") String show_start_date, HttpSession session) throws ParseException {

        List<PlatoonBean> platoons = pLatoonService.getPlatoon(Integer.parseInt(film_id),Integer.parseInt(cinema_id),show_start_date);
        return platoons;
    }

}
