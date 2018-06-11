package com.ticket.UserInfo.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Shinelon on 2018/6/8.
 */
public class Order implements Serializable{
    //数据库f_order 字段
    private int id;
    private int cinemaId;
    private int seatId;
    private int filmId;
    //票数
    private int ticketNum;
    private double price;
    private double totalPrice;
    //下订单事件  超过十五分钟删除订单
   /* @DateTimeFormat(pattern = "yy-MM-dd hh:mm:ss")*/
    private Date orderTime;
    private int costState;
    private int userId;
    private int platoonId;


    //为了省去对应关系而建立的字段
    private String filmName;
    //影院
    private String cinemaName;
    //电影场次
    private String movieField;
    //订单电话号（登陆的电话号）
    private String tel;
    //电影图像
    private String filmImg;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public int getCostState() {
        return costState;
    }

    public void setCostState(int costState) {
        this.costState = costState;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPlatoonId() {
        return platoonId;
    }

    public void setPlatoonId(int platoonId) {
        this.platoonId = platoonId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getMovieField() {
        return movieField;
    }

    public void setMovieField(String movieField) {
        this.movieField = movieField;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFilmImg() {
        return filmImg;
    }

    public void setFilmImg(String filmImg) {
        this.filmImg = filmImg;
    }
}
