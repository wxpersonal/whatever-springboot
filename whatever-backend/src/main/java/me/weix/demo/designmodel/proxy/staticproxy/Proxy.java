package me.weix.demo.designmodel.proxy.staticproxy;

/**
 * @Author: Wells.Wei
 * @Date: 2017/4/26
 * @Description:
 */
public class Proxy implements Subject{

    private Subject subject;

    public Proxy(Subject subject){
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("--------start proxy");
        subject.request();
        System.out.println("--------end proxy");
    }
}
