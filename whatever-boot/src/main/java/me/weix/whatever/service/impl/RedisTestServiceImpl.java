package me.weix.whatever.service.impl;

import me.weix.whatever.service.IRedisTestService;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisTestServiceImpl implements IRedisTestService {

    @Resource(name = "redisTemplate")
    private ValueOperations valueOperations;


    @Override
    public void put(String key, Object value) {
//        valueOperations.getOperations()
        valueOperations.set(key, value);
    }


    @Override
    public Object get(String key) {
        return valueOperations.get(key);
    }
}
