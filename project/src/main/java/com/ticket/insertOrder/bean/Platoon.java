package com.ticket.insertOrder.bean;

import com.ticket.film.entity.FilmDetail;
import com.ticket.film.entity.HallBean;

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
    private FilmDetail film;
    private HallBean hallBean;
    private Seat seat;

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public FilmDetail getFilm() {
        return film;
    }

    public void setFilm(FilmDetail film) {
        this.film = film;
    }

    public HallBean getHallBean() {
        return hallBean;
    }

    public void setHallBean(HallBean hallBean) {
        this.hallBean = hallBean;
    }

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
}
