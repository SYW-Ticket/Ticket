package com.ticket.film.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.ticket.film.dao.impl.FilmDao;
import com.ticket.film.entity.FilmDetail;
import com.ticket.film.entity.PageBean;
import com.ticket.film.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author wangpeng
 * @Date 2018/6/7
 * @Time 11:24
 */
@Controller
@RequestMapping("/film")
public class FilmController {
    @Resource
    private FilmService filmService;

//    @RequestMapping("/LoadingFilmsByPage/{currentPage}")
//    public String findAllFilmsLoadingByPage(@PathVariable("currentPage") int currentPage, Model model){
//        model.addAttribute("pageBean",filmService.findAllFilmsLoadingByPage(currentPage));
//        return "/filmList";
//    }
//    @RequestMapping("/willLoadByPage/{currentPage}")
//    public String willLoadByPage(@PathVariable("currentPage") int currentPage, Model model){
//        model.addAttribute("pageBean",filmService.filmsWillLoadByPage(currentPage));
//        return "/filmList";
//    }
    @RequestMapping("/LoadingByPage/{currentPage}")
    public String pageLoading(@PathVariable("currentPage") int currentPage,HttpSession session){
        PageHelper.startPage(currentPage,5);
        List<FilmDetail> list = filmService.allFilmDetailsLoading();
        PageInfo<FilmDetail> pageInfo = new PageInfo<>(list);
        session.setAttribute("pageInfo",pageInfo);
        return "/filmList";
    }
    @RequestMapping("/willLoadByPage/{currentPage}")
    public String pageWillLoad(@PathVariable("currentPage") int currentPage,HttpSession session,Model model){
        PageHelper.startPage(currentPage,5);
        List<FilmDetail> list = filmService.allFilmDetailsWillLoad();
        PageInfo<FilmDetail> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "/filmList";
    }

    @RequestMapping("/filmDetails/{filmId}")
    public String filmDetails(@PathVariable("filmId") int filmId,Model model){
        System.out.println("controller+++"+Thread.currentThread());
        model.addAttribute("filmDetail", filmService.filmDetail(filmId));
        return "/filmDetails";
    }
}
