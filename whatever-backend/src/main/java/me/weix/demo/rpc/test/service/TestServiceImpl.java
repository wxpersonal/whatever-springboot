package me.weix.demo.rpc.test.service;

/**
 * Created by Administrator on 2017/8/12.
 */
public class TestServiceImpl implements ITestServcie {
    @Override
    public String sayHello(String name) {
        return "HELLO";
    }
}
