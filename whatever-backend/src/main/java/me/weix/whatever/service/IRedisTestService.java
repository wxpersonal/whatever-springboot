package me.weix.whatever.service;

/**
 * @author weix
 */
public interface IRedisTestService {

    void put(String key, Object value);

    Object get(String key);
}
