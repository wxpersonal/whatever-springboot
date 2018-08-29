package me.weix.whatever.service;

public interface IRedisTestService {

    void put(String key, Object value);

    Object get(String key);
}
