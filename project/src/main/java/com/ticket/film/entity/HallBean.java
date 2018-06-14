package com.ticket.film.entity;


import java.io.Serializable;
import java.util.List;

public class HallBean implements Serializable {
    private int id;
    private String hall_name;
    private int row_max;
    private int col_max;
    private int cinema_id;
    private CinemaBean cinemaBean;
    private List<Seat> seats;

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHall_name() {
        return hall_name;
    }

    public void setHall_name(String hall_name) {
        this.hall_name = hall_name;
    }

    public int getRow_max() {
        return row_max;
    }

    public void setRow_max(int row_max) {
        this.row_max = row_max;
    }

    public int getCol_max() {
        return col_max;
    }

    public void setCol_max(int col_max) {
        this.col_max = col_max;
    }

    public int getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(int cinema_id) {
        this.cinema_id = cinema_id;
    }

    public CinemaBean getCinemaBean() {
        return cinemaBean;
    }

    public void setCinemaBean(CinemaBean cinemaBean) {
        this.cinemaBean = cinemaBean;
    }

    @Override
    public String toString() {
        return "HallBean{" +
                "id=" + id +
                ", hall_name='" + hall_name + '\'' +
                ", row_max=" + row_max +
                ", col_max=" + col_max +
                ", cinema_id=" + cinema_id +
                ", cinemaBean=" + cinemaBean +
                ", seats=" + seats +
                '}';
    }
}
