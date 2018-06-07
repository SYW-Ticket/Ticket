package com.ticket.film.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author wangpeng
 * @Date 2018/6/6
 * @Time 14:59
 */
@Component
public class FilmDetail implements Serializable{
    //电影id
    private int id;
    //电影名称
    private String filmName;
    //电影海报
    private String filmImg;
    //电影评分
    private int filmScore;
    //电影热度
    private int filmHot;
    //别名
    private String details;
    //上映时间
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date filmStartDate;
    //导演
    private String director;
    //剧情
    private String synopsis;
    //3d等级
    private String threeDLV;
    //语言
    private String language;
    //时长
    private String filmLength;
    //预告片地址
    private String trailerAddress;
    //演员
    private List<Actor> actors;
    //电影类型
    private List<String> types;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmImg() {
        return filmImg;
    }

    public void setFilmImg(String filmImg) {
        this.filmImg = filmImg;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getFilmStartDate() {
        return filmStartDate;
    }

    public void setFilmStartDate(Date filmStartDate) {
        this.filmStartDate = filmStartDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getThreeDLV() {
        return threeDLV;
    }

    public void setThreeDLV(String threeDLV) {
        this.threeDLV = threeDLV;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(String filmLength) {
        this.filmLength = filmLength;
    }

    public String getTrailerAddress() {
        return trailerAddress;
    }

    public void setTrailerAddress(String trailerAddress) {
        this.trailerAddress = trailerAddress;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "FilmDetail{" +
                "id=" + id +
                ", filmName='" + filmName + '\'' +
                ", filmImg='" + filmImg + '\'' +
                ", filmScore=" + filmScore +
                ", filmHot=" + filmHot +
                ", details='" + details + '\'' +
                ", filmStartDate=" + filmStartDate +
                ", director='" + director + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", threeDLV='" + threeDLV + '\'' +
                ", language='" + language + '\'' +
                ", filmLength='" + filmLength + '\'' +
                ", trailerAddress='" + trailerAddress + '\'' +
                ", actors=" + actors +
                ", types=" + types +
                '}';
    }
}
