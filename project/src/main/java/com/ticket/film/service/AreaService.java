package com.ticket.film.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ticket.film.dao.AreaDao;
import com.ticket.film.entity.AreaBean;
import com.ticket.film.entity.FilmDetail;
import com.ticket.loginandregister.redis.Redisimpl.Redisimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class AreaService {

    @Autowired
    AreaDao areaDao;

    @Autowired
    Redisimpl redisimpl;

    public List<AreaBean> findAllArea(){
        Gson gson = new Gson();
        String strfindAllArea = redisimpl.getValueByKey("findAllArea");
        if(strfindAllArea != null && !strfindAllArea.equals("")){
            //转为List<AreaBean>对象
            Type type =  new TypeToken<ArrayList<AreaBean>>(){}.getType();
            List<AreaBean> areas = gson.fromJson(strfindAllArea,type);
            //返回
            return areas;
        }
        //缓存不存在，查询数据库
        else {
            List<AreaBean> areas = areaDao.findAllArea();
            strfindAllArea = gson.toJson(areas);
            redisimpl.saveString("findAllArea",strfindAllArea);
            return areas;
        }
    }

}
