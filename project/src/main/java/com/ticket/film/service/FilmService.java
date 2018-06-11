package com.ticket.film.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ticket.film.dao.impl.FilmDao;
import com.ticket.film.entity.FilmDetail;
import com.ticket.loginandregister.redis.Redisimpl.Redisimpl;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangpeng
 * @Date 2018/6/7
 * @Time 11:08
 */
@Service
public class FilmService {
    @Resource
    private FilmDao filmDao;
    @Resource
    private Redisimpl redisImpl;
    @Resource
    private JmsTemplate jmsTemplateHot;
//    public PageBean findAllFilms
// LoadingByPage(int currentPage){
//        PageBean pageBean = new PageBean();
//        int count = filmDao.selectLoadingCounts();
//        int countPage = count%PageBean.PAGE_SIZE > 0 ? count/PageBean.PAGE_SIZE+1:count/PageBean.PAGE_SIZE;
//        int start = (currentPage-1)*PageBean.PAGE_SIZE;
//        List<FilmDetail> filmDetails = filmDao.filmsLoadingByPage(start);
//        pageBean.setCurrentPage(currentPage);
//        pageBean.setFilmDetails(filmDetails);
//        pageBean.setCountPage(countPage);
//        return pageBean;
//    }
//    public PageBean filmsWillLoadByPage(int currentPage){
//        PageBean pageBean = new PageBean();
//        int count = filmDao.selectWillLoadCounts();
//        int countPage = count%PageBean.PAGE_SIZE > 0 ? count/PageBean.PAGE_SIZE+1:count/PageBean.PAGE_SIZE;
//        int start = (currentPage-1)*PageBean.PAGE_SIZE;
//        List<FilmDetail> filmDetails = filmDao.filmsWillLoadByPage(start);
//        pageBean.setCurrentPage(currentPage);
//        pageBean.setFilmDetails(filmDetails);
//        pageBean.setCountPage(countPage);
//        return pageBean;
//    }

    public PageInfo<FilmDetail> filmDetailsLoadingByPage(int currentPage){
        //pageHelper设置
        PageHelper.startPage(currentPage,5);
        PageInfo<FilmDetail> pageInfo = null;
        //gson工具
        Gson gson = new Gson();
        //查询缓存
        String key = "filmDetailsLoading_"+currentPage;
        String strFilmDetails = redisImpl.getValueByKey(key);
        //缓存不为空
        if(strFilmDetails != null && !strFilmDetails.equals("")){
            //转为List<FilmDetail>对象
            Type type =  new TypeToken<ArrayList<FilmDetail>>(){}.getType();
            List<FilmDetail> filmDetails = gson.fromJson(strFilmDetails,type);
            //查询缓存得到pageInfo
            String strPageInfo = (redisImpl.getValueByKey("filmDetailsLoadingPageInfo"));
            pageInfo = gson.fromJson(strPageInfo,PageInfo.class);
            //更新list
            if(pageInfo != null) {
                pageInfo.setPageNum(currentPage);
                pageInfo.setList(filmDetails);
            }
            //返回
            return pageInfo;
        }
        //缓存不存在，查询数据库
        else {
            List<FilmDetail> filmDetails = filmDao.filmsLoading();
            //转化为json存入redis
            strFilmDetails = gson.toJson(filmDetails);
            redisImpl.saveString(key,strFilmDetails);
            //包装pageInfo对象
            pageInfo = new PageInfo<>(filmDetails);
            //pageInfo存入缓存
            String strPageInfo = gson.toJson(pageInfo);
            redisImpl.saveString("filmDetailsLoadingPageInfo",strPageInfo);
            return pageInfo;
        }

    }
    public PageInfo<FilmDetail> FilmsDetailsWillLoadByPage(int currentPage){
        //pageHelper设置
        PageHelper.startPage(currentPage,5);
        PageInfo<FilmDetail> pageInfo = null;
        //gson工具
        Gson gson = new Gson();
        //查询缓存
        String key = "filmDetailsWillLoad_"+currentPage;
        String strFilmDetails = redisImpl.getValueByKey(key);
        //缓存不为空
        if(strFilmDetails != null && !strFilmDetails.equals("")){
            //转为List<FilmDetail>对象
            Type type =  new TypeToken<ArrayList<FilmDetail>>(){}.getType();
            List<FilmDetail> filmDetails = gson.fromJson(strFilmDetails,type);
            //查询缓存得到pageInfo
            String strPageInfo = (redisImpl.getValueByKey("filmDetailsWillLoadPageInfo"));
            pageInfo = gson.fromJson(strPageInfo,PageInfo.class);
            //更新list
            pageInfo.setList(filmDetails);
            //返回
            return pageInfo;
        }
        //缓存不存在，查询数据库
        else {
            List<FilmDetail> filmDetails = filmDao.filmsWillLoad();
            //转化为json存入redis
            strFilmDetails = gson.toJson(filmDetails);
            redisImpl.saveString(key,strFilmDetails);
            //包装pageInfo对象
            pageInfo = new PageInfo<>(filmDetails);
            //pageInfo存入缓存
            String strPageInfo = gson.toJson(pageInfo);
            redisImpl.saveString("filmDetailsWillLoadPageInfo",strPageInfo);
            return pageInfo;
        }
    }
    public FilmDetail filmDetail(int filmId){
        Gson gson =new Gson();
        String key = "filmId_"+filmId;
        //将点击事件消息队列异步处理
        final String keyForHot = "filmIdForHot_"+filmId;
        System.out.println("Service+++"+Thread.currentThread());
        jmsTemplateHot.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(keyForHot);
            }
        });
        //查询缓存，若没有再查询数据库
        String strFilmDetail = redisImpl.getValueByKey(key);
        if(strFilmDetail != null && !strFilmDetail.equals("")){
            FilmDetail filmDetail = gson.fromJson(strFilmDetail,FilmDetail.class);
            return filmDetail;
        }else {
            //查询数据库，并将数据存入redis
            FilmDetail filmDetail = filmDao.filmDetail(filmId);
            strFilmDetail = gson.toJson(filmDetail);
            redisImpl.saveString(key,strFilmDetail);
            return filmDetail;
        }
    }
}
