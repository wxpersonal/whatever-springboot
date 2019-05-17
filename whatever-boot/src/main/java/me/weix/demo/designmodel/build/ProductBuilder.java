package me.weix.demo.designmodel.build;

/**
 * @author Administrator
 * @date 2018/12/3 16:05
 * @description
 */
public interface ProductBuilder {

    void buildPart1();

    void buildPart2();

    void buildPart3();

    Product buildProduct();
}
