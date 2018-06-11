package com.ticket.film.entity;

/**
 * @Author wangpeng
 * @Date 2018/6/11
 * @Time 11:44
 */
public class Seat {
    private int id;
    private int flag;
    private int row;
    private int col;
    private String name;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", flag=" + flag +
                ", row=" + row +
                ", col=" + col +
                ", name='" + name + '\'' +
                '}';
    }
}
