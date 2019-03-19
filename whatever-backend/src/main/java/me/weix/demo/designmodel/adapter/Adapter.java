package me.weix.demo.designmodel.adapter;

/**
 * @Author: Wells.Wei
 * @Date: 2017/5/2
 * @Description:
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        System.out.println("新添加的适配方法");
    }
}
