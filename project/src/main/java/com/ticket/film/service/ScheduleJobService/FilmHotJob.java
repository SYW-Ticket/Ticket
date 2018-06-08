package com.ticket.film.service.ScheduleJobService;

import com.ticket.film.dao.impl.FilmDao;
import com.ticket.film.writedao.impl.FilmWriteDao;
import com.ticket.loginandregister.redis.Redisimpl.Redisimpl;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @Author wangpeng
 * @Date 2018/6/8
 * @Time 15:48
 */
public class FilmHotJob implements Job {
    @Resource
    private Redisimpl redisImpl;
    @Resource
    private FilmWriteDao filmWriteDao;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("测试job==========================");
        //获取redis里所有的filmIdForHot_'id'的key，正则表达式："filmIdForHot_*"
        Set<String> keys = redisImpl.selectKeysLike("filmIdForHot_*");
        //遍历keys
        if(keys != null) {
            for (String key : keys) {
                //得到电影id
                String strId = key.substring(13);
                int filmId = Integer.valueOf(strId);
                //得到电影新增热度
                int hotOnIncr = Integer.valueOf(redisImpl.getValueByKey(key));
                //查询电影热度
                int hot = filmWriteDao.selectFilmHot(filmId);
                //更新电影热度
                filmWriteDao.updateFilmHot(filmId, hot + hotOnIncr);
                //清除缓存新增热度
                redisImpl.deleteKeyValue(key);
                //清除电影详情
                redisImpl.deleteKeyValue("filmId_" + filmId);
            }
            //清除（更新）redis的filmDetails电影详情列表缓存
            redisImpl.deleteKeyValue("filmDetailsLoading");
            redisImpl.deleteKeyValue("filmDetailsWillLoad");
            System.out.println("缓存已经清除，数据库热度已更新");
        }


    }
}
