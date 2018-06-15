package com.ticket.insertOrder.util;

import com.ticket.loginandregister.redis.Redis;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wangpeng
 * @Date 2018/6/15
 * @Time 11:26
 */
@Repository
public class RedisWatch {
    @Resource
    private StringRedisTemplate redisTemplate;
    @Resource
    private Redis redis;

    public boolean watchSeats(int[] seat_ids, int platon_id) {
        for (int i = 0; i < seat_ids.length; i++) {
            String keyForSecurity = String.valueOf("test_" + seat_ids[i] + "_platoon_" + platon_id);
            //加锁防止此处并发（情况：多线程同时进入，部分线程准备修改，部分线程修改完并有一个线程完成了占座，准备修改的线程将座位状态重置，引发多选问题）
            synchronized (keyForSecurity) {
                if (!redisTemplate.hasKey(keyForSecurity)) {
                    //初始化座位seatStatus = 0,0为初始值,用于watch监听
                    redis.saveString(keyForSecurity, "0");
                }
            }
            //以上面的key取座位的状态信息
            String strSeatStatus = redisTemplate.opsForValue().get(keyForSecurity);
            int seatStatus = Integer.valueOf(strSeatStatus);
            //判断是否被占座
            if (seatStatus != 1) {
                //以下代码并发下会被多线程访问，知道座位状态被修改，才不会有线程 进来
                //开启redis事务支持
                redisTemplate.setEnableTransactionSupport(true);
                //监听座位id的key
                redisTemplate.watch(keyForSecurity);
                //开启事务
                redisTemplate.multi();
                //修改座位状态（占座）
                redisTemplate.opsForValue().set(keyForSecurity, "1");
                //!!!!!坑！！！！额外加一次查询，不然exec提交始终返回空
                redisTemplate.opsForValue().get(keyForSecurity);
//                //睡眠，测试用，使并发测试的所有线程都能进入占座的事务操作
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                //提交事务
                List<Object> list = redisTemplate.exec();
                //如果返回不为空，证明当前线程的事务提交成功，否则失败
                if (list == null || list.size() == 0) {
                    //提醒用户,"同时多人选座,您慢了一点点"
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
