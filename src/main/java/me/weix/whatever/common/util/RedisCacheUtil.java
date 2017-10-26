package me.weix.whatever.common.util;

/**
 * Created by wxper on 2017/4/1.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class RedisCacheUtil<T> {

    @Autowired
    @Qualifier("redisTemplate")
    public RedisTemplate redisTemplate;

    /**
     * 缓存基本的对象，Integer、String、实体类等
     * @param key 缓存的键值
     * @param value 缓存的值
     * @return  缓存的对象
     */
    public <T> ValueOperations<String,T> putIfAbsent(String key,T value) {
        ValueOperations<String,T> operation = redisTemplate.opsForValue();
        operation.set(key, value);
        return operation;
    }

    /**
     * 缓存基本的对象，Integer、String、实体类等
     * @param key 缓存的键值
     * @param value 缓存的值
     * @param expireTime 缓存时间
     * @param timeUnit 缓存时间
     * @return  缓存的对象
     */
    public <T> ValueOperations<String,T> putIfAbsent(String key,T value ,long expireTime, TimeUnit timeUnit) {
        ValueOperations<String,T> operation = redisTemplate.opsForValue();
        operation.set(key,value);
        //缓存失效时间设置
        redisTemplate.expire(key, expireTime, timeUnit);
        return operation;
    }

    /**
     * 获得缓存的基本对象。
     * @param key  缓存键值
     * @return   缓存键值对应的数据
     */
    public <T> T getCacheObject(String key) {
        ValueOperations<String,T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * 缓存List数据
     * @param key  缓存的键值
     * @param dataList 待缓存的List数据
     * @return   缓存的对象
     */
    public <T> ListOperations<String, T> putIfAbsent(String key, List<T> dataList) {
        ListOperations listOperation = redisTemplate.opsForList();
        if(null != dataList)
        {
            int size = dataList.size();
            for(int i = 0; i < size ; i ++) {
                listOperation.rightPush(key,dataList.get(i));
            }
        }
        return listOperation;
    }

    /**
     * 获得缓存的list对象
     * @param key 缓存的键值
     * @return  缓存键值对应的数据
     */
    public <T> List<T> getList(String key) {
        List<T> dataList = new ArrayList<T>();
        ListOperations<String,T> listOperation = redisTemplate.opsForList();
        Long size = listOperation.size(key);
        for(int i = 0 ; i < size ; i ++) {
            dataList.add((T) listOperation.leftPop(key));
        }
        return dataList;
    }

    /**
     * 缓存Set
     * @param key  缓存键值
     * @param dataSet 缓存的数据
     * @return   缓存数据的对象
     */
    public <T> BoundSetOperations<String,T> putIfAbsent(String key, Set<T> dataSet) {

        BoundSetOperations<String,T> setOperation = redisTemplate.boundSetOps(key);
        Iterator<T> it = dataSet.iterator();
        while(it.hasNext()) {
            setOperation.add(it.next());
        }
        return setOperation;
    }

    /**
     * 获得缓存的set
     * @param key
     * @return
     */
    public Set<T> getSet(String key) {
        Set<T> dataSet = new HashSet<T>();
        BoundSetOperations<String,T> operation = redisTemplate.boundSetOps(key);
        Long size = operation.size();
        for(int i = 0 ; i < size ; i++) {
            dataSet.add(operation.pop());
        }
        return dataSet;
    }

    /**
     * 缓存Map
     * @param key
     * @param dataMap
     * @return
     */
    public <E,T> HashOperations<String,E,T> putIfAbsent(String key, Map<E,T> dataMap) {
        HashOperations<String, E, T> hashOperations = redisTemplate.opsForHash();
        if(null != dataMap) {
            for (Map.Entry<E, T> entry : dataMap.entrySet()) {
                hashOperations.put(key,entry.getKey(),entry.getValue());
            }
        }
        return hashOperations;
    }

    /**
     * 获得缓存的Map
     * @param key
     * @return
     */
    public <E,T> Map<E,T> getCacheMap(String key) {
        Map<E, T> map = redisTemplate.opsForHash().entries(key);
        return map;
    }

    /**
     * 根据key删除相应内容
     * @param key
     */
    public void deleteObjectByKey (String key) {
        redisTemplate.delete(key);
    }
}

