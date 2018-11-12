package me.weix.whatever.util;

/**
 * Created by wxper on 2017/4/1.
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class RedisUtil {

    private static RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) SpringContextUtil.getBean("redisTemplate");

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key   缓存的键值
     * @param value 缓存的值
     * @return 缓存的对象
     */
    public static void set(String key, Object value) {
        try {
            ValueOperations<String, Object> operation = redisTemplate.opsForValue();
            operation.set(key, objectMapper.writeValueAsString(value));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key        缓存的键值
     * @param value      缓存的值
     * @param expireTime 缓存时间
     * @param timeUnit   缓存时间
     * @return 缓存的对象
     */
    public static ValueOperations set(String key, Object value, long expireTime, TimeUnit timeUnit) {
        ValueOperations<String, Object> operation = redisTemplate.opsForValue();
        try {
            operation.set(key, objectMapper.writeValueAsString(value));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //缓存失效时间设置
        redisTemplate.expire(key, expireTime, timeUnit);
        return operation;
    }

    /**
     * 获得缓存的基本对象。
     *
     * @param key 缓存键值
     * @return 缓存键值对应的数据
     */
    public static Object getCachedObject(String key) {
        ValueOperations<String, Object> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * 缓存List数据
     *
     * @param key      缓存的键值
     * @param dataList 待缓存的List数据
     * @return 缓存的对象
     */
    public static ListOperations<String, Object> set(String key, List<Object> dataList) {
        ListOperations listOperation = redisTemplate.opsForList();
        if (null != dataList) {
            int size = dataList.size();
            for (int i = 0; i < size; i++) {
                try {
                    listOperation.rightPush(key, objectMapper.writeValueAsString(dataList.get(i)));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
        return listOperation;
    }

    /**
     * 获得缓存的list对象
     *
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    public static List<Object> getList(String key) {
        List<Object> dataList = new ArrayList<Object>();
        ListOperations<String, Object> listOperation = redisTemplate.opsForList();
        Long size = listOperation.size(key);
        for (int i = 0; i < size; i++) {
            dataList.add((Object) listOperation.leftPop(key));
        }
        return dataList;
    }

    /**
     * 缓存Set
     *
     * @param key     缓存键值
     * @param dataSet 缓存的数据
     * @return 缓存数据的对象
     */
    public static BoundSetOperations<String, Object> set(String key, Set<Object> dataSet) {

        BoundSetOperations<String, Object> setOperation = redisTemplate.boundSetOps(key);
        Iterator<Object> it = dataSet.iterator();
        while (it.hasNext()) {
            try {
                setOperation.add(objectMapper.writeValueAsString(it.next()));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return setOperation;
    }

    /**
     * 获得缓存的set
     *
     * @param key
     * @return
     */
    public static Set getSet(String key) {
        Set<Object> dataSet = new HashSet<Object>();
        BoundSetOperations<String, Object> operation = redisTemplate.boundSetOps(key);
        Long size = operation.size();
        for (int i = 0; i < size; i++) {
            dataSet.add(operation.pop());
        }
        return dataSet;
    }

    /**
     * 缓存Map
     *
     * @param key
     * @param dataMap
     * @return
     */
    public static HashOperations set(String key, Map<Object, Object> dataMap) {
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        if (null != dataMap) {
            for (Map.Entry<Object, Object> entry : dataMap.entrySet()) {
                try {
                    hashOperations.put(key, objectMapper.writeValueAsString(entry.getKey()),
                            objectMapper.writeValueAsString(entry.getValue()));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
        return hashOperations;
    }

    /**
     * 获得缓存的Map
     *
     * @param key
     * @return
     */
    public static Map<Object, Object> getCacheMap(String key) {
        Map<Object, Object> map = redisTemplate.opsForHash().entries(key);
        return map;
    }

    /**
     * 根据key删除相应内容
     *
     * @param key
     */
    public static void deleteObjectByKey(String key) {
        redisTemplate.delete(key);
    }
}

