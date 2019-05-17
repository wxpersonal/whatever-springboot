package me.weix.demo.designmodel.bridge;

/**
 * @author weix
 * @date 2018/12/4 14:24
 */
public class ConcreteAbstraction extends Abstraction {

    public ConcreteAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation1() {
        this.getImplementor().operation1();
    }

    @Override
    public void operation2() {
        this.getImplementor().operation2();
    }
}
