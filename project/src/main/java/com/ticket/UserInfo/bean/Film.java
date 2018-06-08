package com.ticket.UserInfo.bean;

/**
 * Created by Shinelon on 2018/6/8.
 */
public class Film {


    private int id;
    private String filmImg;
    private String filmName;
    private int filmScore;
    private int filmHot;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilmImg() {
        return filmImg;
    }

    public void setFilmImg(String filmImg) {
        this.filmImg = filmImg;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getFilmScore() {
        return filmScore;
    }

    public void setFilmScore(int filmScore) {
        this.filmScore = filmScore;
    }

    public int getFilmHot() {
        return filmHot;
    }

    public void setFilmHot(int filmHot) {
        this.filmHot = filmHot;
    }
}
