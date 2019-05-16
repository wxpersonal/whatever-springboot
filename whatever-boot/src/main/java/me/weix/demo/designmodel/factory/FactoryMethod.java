package me.weix.demo.designmodel.factory;

import me.weix.demo.designmodel.factory.model.Model;

/**
 * @Author: Wells.Wei
 * @Date: 2017/4/24
 * @Description: 工厂方法
 *               工厂方法模式定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个，也就是说工厂方法模式让实例化推迟到子类。
 */
public abstract class FactoryMethod {

    public abstract Model create();
}
