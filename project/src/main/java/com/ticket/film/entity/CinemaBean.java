package com.ticket.film.entity;

public class CinemaBean {
    private int id;
    private String cinema_name;
    private String cinema_adress;
    private String cinema_tel;
    private int area_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCinema_name() {
        return cinema_name;
    }

    public void setCinema_name(String cinema_name) {
        this.cinema_name = cinema_name;
    }

    public String getCinema_adress() {
        return cinema_adress;
    }

    public void setCinema_adress(String cinema_adress) {
        this.cinema_adress = cinema_adress;
    }

    public String getCinema_tel() {
        return cinema_tel;
    }

    public void setCinema_tel(String cinema_tel) {
        this.cinema_tel = cinema_tel;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }
}
