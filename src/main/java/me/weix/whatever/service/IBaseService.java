package me.weix.whatever.service;

import java.util.List;

/**
 * @Author: Wells.Wei
 * @Date: 2017/4/25
 * @Description:
 */
public interface IBaseService<T> {

    Integer insert(T obj);

    T getById(Integer id);

    Integer update(T obj);

    Integer delete(String ids);

    List<T> list();

    void initMapper();
}
