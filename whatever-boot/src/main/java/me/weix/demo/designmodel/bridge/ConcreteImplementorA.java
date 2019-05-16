package me.weix.demo.designmodel.bridge;

/**
 * 抽象子类  实现抽象方法
 * @author weix
 * @date 2018/12/4 14:20
 */
public class ConcreteImplementorA implements Implementor {

    @Override
    public void operation1() {
        System.out.println("ConcreteImplementorA operation1");
    }

    @Override
    public void operation2() {
        System.out.println("ConcreteImplementorA operation2");
    }
}
