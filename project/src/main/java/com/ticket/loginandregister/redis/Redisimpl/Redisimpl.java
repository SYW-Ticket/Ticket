package com.ticket.loginandregister.redis.Redisimpl;

import com.ticket.loginandregister.redis.Redis;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;


@Component
public class Redisimpl implements Redis {

    @Resource
    StringRedisTemplate redisTemplate;

    //获得缓存字符串
    @Override
    public String getValueByKey(String key) {
        return redisTemplate.boundValueOps(key).get();
    }


    //获得缓存set集合，如果要存储对象只能将对象转换成json字符串
    @Override
    public Set<String> getSetByKey(String key) {
        return redisTemplate.boundSetOps(key).members();
    }

    //保存字符串缓存
    @Override
    public void saveString(String key, String value) {
       redisTemplate.boundValueOps(key).set(value);
    }


    @Override
    public String saveObject(String key, Object obj) {
        return null;
    }
    //保存字符串集合
    @Override
    public Integer saveSet(String key, Set<String> set) {
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            redisTemplate.boundSetOps(key).add(next);
        }
        return 0;

    }

    @Override
    public void incr(String key) {
        RedisAtomicLong redisAtomicLong = new RedisAtomicLong(key,redisTemplate.getConnectionFactory());
        redisAtomicLong.getAndIncrement();
    }

    //保存字符串并只保存20分钟
    public void saveStringToSet(String key,String value){
        redisTemplate.opsForValue().set(key,value,20,TimeUnit.MINUTES);
    }
    //模糊查询keys
    public Set <String> selectKeysLike(String pattern){
        return redisTemplate.keys(pattern);
    }

    @Override
    public void deleteKeyValue(String key) {
        redisTemplate.delete(key);
    }
    @Override
    public void deleteKeys(Set<String> keys) {
        redisTemplate.delete(keys);
    }

    public void saveStringToSet(String key,String value,int staytime){
        redisTemplate.opsForValue().set(key,value,staytime,TimeUnit.MINUTES);
    }
}
