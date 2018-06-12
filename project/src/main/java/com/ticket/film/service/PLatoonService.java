package com.ticket.film.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ticket.film.dao.PlatoonDao;
import com.ticket.film.entity.FilmDetail;
import com.ticket.film.entity.PlatoonBean;
import com.ticket.loginandregister.redis.Redis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PLatoonService {
    @Autowired
    private PlatoonDao platoonDao;

    @Autowired
    private Redis redis;

    public List<PlatoonBean> getPlatoon(int film_id,int cinema_id,String str) throws ParseException {
        Gson gson = new Gson();
        //查询缓存
        String key = "platoon"+film_id+"_"+cinema_id+str;
        String strPlatoon = redis.getValueByKey(key);
        //缓存不为空
        if(strPlatoon != null && !strPlatoon.equals("")){
            //转为List<FilmDetail>对象
            Type type =  new TypeToken<ArrayList<PlatoonBean>>(){}.getType();
            List<PlatoonBean> platoons = gson.fromJson(strPlatoon,type);
            //返回
            return platoons;
        }
        //缓存不存在，查询数据库
        else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            date = sdf.parse(str);
            HashMap<String,Object> map = new HashMap<>();
            map.put("film_id",film_id);
            map.put("cinema_id",cinema_id);
            map.put("show_start_date",date);
            List<PlatoonBean> platoons = platoonDao.selectAllPlatoonByFilm_id(map);
            strPlatoon = gson.toJson(platoons);
            redis.saveString(key,strPlatoon);
            return platoons;
        }
    }
}
