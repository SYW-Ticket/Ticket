package com.ticket.film.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

/**
 * @Author wangpeng
 * @Date 2018/6/7
 * @Time 11:05
 */
public class PageBean {
    private int currentPage;
    private int countPage;
    private List<FilmDetail> filmDetails;
    public static final int PAGE_SIZE= 5;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    public List<FilmDetail> getFilmDetails() {
        return filmDetails;
    }

    public void setFilmDetails(List<FilmDetail> filmDetails) {
        this.filmDetails = filmDetails;
    }
}
