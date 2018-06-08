package com.ticket.film.entity;

import java.util.Date;

public class PlatoonBean {
    private int id;
    private int film_id;
    private Date show_start_time;
    private int hall_id;
    private double film_price;
    private FilmDetail film;
    private HallBean hallBean;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public Date getShow_start_time() {
        return show_start_time;
    }

    public void setShow_start_time(Date show_start_time) {
        this.show_start_time = show_start_time;
    }

    public int getHall_id() {
        return hall_id;
    }

    public void setHall_id(int hall_id) {
        this.hall_id = hall_id;
    }

    public double getFilm_price() {
        return film_price;
    }

    public void setFilm_price(double film_price) {
        this.film_price = film_price;
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
}
