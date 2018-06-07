package com.ticket.film.entity;

import java.io.Serializable;

/**
 * @Author wangpeng
 * @Date 2018/6/6
 * @Time 15:23
 */
public class Actor implements Serializable{
    private int id;
    private String actorName;
    private String actorPhoto;
    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorPhoto() {
        return actorPhoto;
    }

    public void setActorPhoto(String actorPhoto) {
        this.actorPhoto = actorPhoto;
    }


    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", actorName='" + actorName + '\'' +
                ", actorPhoto='" + actorPhoto + '\'' +
                ", flag=" + flag +
                '}';
    }
}
