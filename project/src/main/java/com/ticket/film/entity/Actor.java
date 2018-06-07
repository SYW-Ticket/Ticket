package com.ticket.film.entity;

/**
 * @Author wangpeng
 * @Date 2018/6/6
 * @Time 15:23
 */
public class Actor {
    private int id;
    private String actorName;
    private String actorPhoto;

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", actorName='" + actorName + '\'' +
                ", actorPhoto='" + actorPhoto + '\'' +
                '}';
    }
}
