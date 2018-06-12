package com.ticket.UserInfo.bean;

import java.util.Date;

/**
 * Created by Shinelon on 2018/6/8.
 */
public class Platoon {

    private int id;
    private int filmeId;
    private Date showStartTime;
    private int hallId;
    private double filmPrice;
    private Date showStartDate;

    private Hall hall;

    private Film film;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(int filmeId) {
        this.filmeId = filmeId;
    }

    public Date getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(Date showStartTime) {
        this.showStartTime = showStartTime;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public double getFilmPrice() {
        return filmPrice;
    }

    public void setFilmPrice(double filmPrice) {
        this.filmPrice = filmPrice;
    }

    public Date getShowStartDate() {
        return showStartDate;
    }

    public void setShowStartDate(Date showStartDate) {
        this.showStartDate = showStartDate;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
