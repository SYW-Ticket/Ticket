package com.ticket.film.controller;

import com.ticket.loginandregister.redis.Redis;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wangpeng
 * @Date 2018/6/13
 * @Time 20:27
 */
@Controller
@RequestMapping("/test111")
public class TestRedisWatchController {
    @Resource
    private Redis redis;
    @Resource
    private StringRedisTemplate redisTemplate;
    @RequestMapping("/test/{seatId}")
    public void test(@PathVariable("seatId") int seatId){
        //生成座位id的key
        String key = String.valueOf("test_"+seatId);
        if(!redisTemplate.hasKey(key)) {
            //初始化座位seatStatus = 0,0为初始值,用于watch监听,并发的话重置而已，不影响安全
            redis.saveString(key, "0");
        }

        //开启redis事务支持
        redisTemplate.setEnableTransactionSupport(true);
        //以上面的key取座位的状态信息
        String strSeatStatus =  redisTemplate.opsForValue().get(key);
        int seatStatus = Integer.valueOf(strSeatStatus);
        //判断是否被占座
        if(seatStatus != 1){
            //以下代码并发下会被多线程访问，知道座位状态被修改，才不会有线程进来
            //监听座位id的key
            redisTemplate.watch(key);
            //开启事务
            redisTemplate.multi();
            //修改座位状态（占座）
            redisTemplate.opsForValue().set(key,"1");
            //!!!!!坑！！！！额外加一次查询，不然exec提交始终返回空
            redisTemplate.opsForValue().get(key);
            //睡眠，测试用，使并发测试的所有线程都能进入占座的事务操作
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //提交事务
            List<Object> list = redisTemplate.exec();
            //如果返回不为空，证明当前线程的事务提交成功，否则失败
            if(list == null || list.size() == 0){
                System.out.println("+++++++修改失败");
            }else {
                System.out.println("+++++++修改成功");
            }
        }
    }
}
