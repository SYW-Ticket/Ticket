package com.ticket.film.entity;

/**
 * @Author wangpeng
 * @Date 2018/6/6
 * @Time 14:30
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

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", filmImg='" + filmImg + '\'' +
                ", filmName='" + filmName + '\'' +
                ", filmScore=" + filmScore +
                ", filmHot=" + filmHot +
                '}';
    }
}
