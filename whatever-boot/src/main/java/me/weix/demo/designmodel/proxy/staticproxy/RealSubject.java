package me.weix.demo.designmodel.proxy.staticproxy;

/**
 * @Author: Wells.Wei
 * @Date: 2017/4/26
 * @Description:
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("------------------RealSubject");
    }

    public static void main(String[] args){
        RealSubject subject = new RealSubject();
        Proxy p = new Proxy(subject);
        p.request();
    }
}
