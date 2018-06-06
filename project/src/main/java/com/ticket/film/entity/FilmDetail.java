package com.ticket.film.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Author wangpeng
 * @Date 2018/6/6
 * @Time 14:59
 */
@Component
public class FilmDetail {
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
//    @DateTimeFormat(pattern = "YY-MM-DD")
    @DateTimeFormat
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
