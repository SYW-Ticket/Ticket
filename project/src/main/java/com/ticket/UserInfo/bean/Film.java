package com.ticket.UserInfo.bean;

import java.util.Date;
import java.util.List;

/**
 * Created by Shinelon on 2018/6/8.
 */
public class Film {


    private int id;
    private String filmImg;
    private String filmName;
    private int filmScore;
    private int filmHot;


    private int filmDetailsId;
    private int fimlId;
    private String details;
    private Date filmStartDate;
    private String director;
    private String synopsis;
    private Date filmEndDate;
    private String filmLength;
    private String language;
    private String LV3D;
    private String trailerAddress;


    private List<Platoon> platoonList;

    private List<String> types;

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

    public int getFilmDetailsId() {
        return filmDetailsId;
    }

    public void setFilmDetailsId(int filmDetailsId) {
        this.filmDetailsId = filmDetailsId;
    }

    public int getFimlId() {
        return fimlId;
    }

    public void setFimlId(int fimlId) {
        this.fimlId = fimlId;
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

    public Date getFilmEndDate() {
        return filmEndDate;
    }

    public void setFilmEndDate(Date filmEndDate) {
        this.filmEndDate = filmEndDate;
    }

    public String getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(String filmLength) {
        this.filmLength = filmLength;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLV3D() {
        return LV3D;
    }

    public void setLV3D(String LV3D) {
        this.LV3D = LV3D;
    }

    public String getTrailerAddress() {
        return trailerAddress;
    }

    public void setTrailerAddress(String trailerAddress) {
        this.trailerAddress = trailerAddress;
    }

    public List<Platoon> getPlatoonList() {
        return platoonList;
    }

    public void setPlatoonList(List<Platoon> platoonList) {
        this.platoonList = platoonList;
    }
}
