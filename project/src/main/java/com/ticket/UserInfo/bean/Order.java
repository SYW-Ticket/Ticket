package com.ticket.UserInfo.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Shinelon on 2018/6/8.
 */
public class Order implements Serializable{
    //数据库f_order 字段
    private int id;
    private List<Seat> seats;
    //票数
    private int ticketNum;
    private double totalPrice;
    //下订单事件  超过十五分钟删除订单
   /* @DateTimeFormat(pattern = "yy-MM-dd hh:mm:ss")*/
    private Date orderTime;
    private int costState;
    private int userId;
    private int platoonId;

    private Platoon platoon;

    private List<Seat> seatList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
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

    public Platoon getPlatoon() {
        return platoon;
    }

    public void setPlatoon(Platoon platoon) {
        this.platoon = platoon;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
