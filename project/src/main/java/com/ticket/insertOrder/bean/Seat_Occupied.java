package com.ticket.insertOrder.bean;

public class Seat_Occupied {
    private int id;
    private int seat_occupied;
    private int seat_id;
    private int order_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeat_occupied() {
        return seat_occupied;
    }

    public void setSeat_occupied(int seat_occupied) {
        this.seat_occupied = seat_occupied;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
