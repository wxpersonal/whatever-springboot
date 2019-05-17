package me.weix.demo.designmodel.decorator;

/**
 * @Author: weix
 * @Date: 2017/5/6
 * @Description: 定义被装饰者，被装饰者初始状态有些自己的装饰
 */
public class Person implements Human {

    @Override
    public void wearClothes() {
        System.out.println("穿什么呢。。");
    }

    @Override
    public void walk() {
        System.out.println("去哪里呢。。");
    }
}
