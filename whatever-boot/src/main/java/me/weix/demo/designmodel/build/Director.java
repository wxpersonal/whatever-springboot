package me.weix.demo.designmodel.build;

/**
 * 建造者   　建造者模式是在当创建复杂对象的复杂算法一个独立与该对象的组成部分以及它们的装配方式时适用的模式。
 * @author weix
 * @date 2018/12/3 16:08
 */
public class Director {

    public Product constructProduct(ConcreteProductBuilder builder) {
        builder.buildPart1();
        builder.buildPart2();
        builder.buildPart3();
        Product product = builder.buildProduct();
        return product;
    }
}
