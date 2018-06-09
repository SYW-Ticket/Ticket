package com.ticket.loginandregister.redis;

import java.util.Set;

public interface Redis {
    //获得字符串Redis缓存
    String getValueByKey(String key);
    //获得Set集合Redis内存
    Set<String> getSetByKey(String key);
    //设置字符串到Redis缓存
    void saveString(String key, String value);
    //保存对象到Redis缓存
    String saveObject(String key, Object obj);
    //保存集合到Redis缓存
    Integer saveSet(String key, Set<String> set);
    // 操作缓存数据自增的方法 by wangpeng
    void incr(String key);
    //模糊查询keys
    Set <String> selectKeysLike(String pattern);
    //删除缓存中指定的key
    void deleteKeyValue(String key);

    void saveStringToSet(String key,String value);
}
