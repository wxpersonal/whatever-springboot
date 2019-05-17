package me.weix.demo.designmodel.bridge;

/**
 * @author weix
 * @date 2018/12/4 14:20
 */
public class ConcreteImplementorB implements Implementor {
    @Override
    public void operation1() {
        System.out.println("ConcreteImplementorB operation1");
    }

    @Override
    public void operation2() {
        System.out.println("ConcreteImplementorB operation2");
    }
}
