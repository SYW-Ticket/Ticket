package com.ticket.film.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ticket.film.dao.CinemaDao;
import com.ticket.film.entity.AreaBean;
import com.ticket.film.entity.CinemaBean;
import com.ticket.loginandregister.redis.Redisimpl.Redisimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
@Service
public class CinemaService {
    @Autowired
    CinemaDao cinemaDao;

    @Autowired
    Redisimpl redisimpl;

    public List<CinemaBean> findCinema(int area_id){
        Gson gson = new Gson();
        String key = "findCinema" + area_id;
        String strfindCinema = redisimpl.getValueByKey(key);
        if(strfindCinema != null && !strfindCinema.equals("")){
            //转为List<AreaBean>对象
            Type type =  new TypeToken<ArrayList<CinemaBean>>(){}.getType();
            List<CinemaBean> cinemas = gson.fromJson(strfindCinema,type);
            //返回
            return cinemas;
        }
        //缓存不存在，查询数据库
        else {
            List<CinemaBean> cinemas = cinemaDao.findcinmeByAreaId(area_id);
            strfindCinema = gson.toJson(cinemas);
            redisimpl.saveString("findCinema",strfindCinema);
            return cinemas;
        }
    }
}
