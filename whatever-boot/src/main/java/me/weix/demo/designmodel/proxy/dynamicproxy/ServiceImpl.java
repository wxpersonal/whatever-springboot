package me.weix.demo.designmodel.proxy.dynamicproxy;

/**
 * @Author: Wells.Wei
 * @Date: 2017/4/26
 * @Description:
 */
public class ServiceImpl implements Service {
    @Override
    public void request() {

        System.out.println("---------------request");
    }

    @Override
    public void method1() {
        System.out.println("method1");
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }
}
