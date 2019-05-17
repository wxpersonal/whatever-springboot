package me.weix.demo.designmodel.bridge;

/**
 * 桥接模式将抽象和实现解耦，使两者可以独立地变化
 * @author weix
 * @date 2018/12/4 14:27
 */
public class Test {

    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementorA();
        Abstraction test = new ConcreteAbstraction(implementor);
        test.operation1();
        test.operation2();
    }
}
