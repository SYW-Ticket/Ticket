package com.ticket.insertOrder.bean;

/**
 * Created by Shinelon on 2018/6/8.
 */
public class Hall {
    private int id;
    private String hallName;
    private int rowMax;
    private int colMax;
    private int cinemaId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public int getRowMax() {
        return rowMax;
    }

    public void setRowMax(int rowMax) {
        this.rowMax = rowMax;
    }

    public int getColMax() {
        return colMax;
    }

    public void setColMax(int colMax) {
        this.colMax = colMax;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }
}
