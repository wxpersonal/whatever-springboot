package me.weix.demo.designmodel.bridge;

/**
 * 抽象类(桥接类)
 * @author weix
 * @date 2018/12/4 14:21
 */
public abstract class Abstraction {

    private Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void operation1();

    public abstract void operation2();

    public Implementor getImplementor() {
        return implementor;
    }

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }
}
