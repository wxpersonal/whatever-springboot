package me.weix.demo.designmodel.build;

/**
 * @author weix
 * @date 2018/12/3 16:06
 */
public class ConcreteProductBuilder implements ProductBuilder {

    private Product product;

    public ConcreteProductBuilder() {
        product = new Product();
    }

    @Override
    public void buildPart1() {
        product.setPart1("part1");
    }

    @Override
    public void buildPart2() {
        product.setPart1("part1");
    }

    @Override
    public void buildPart3() {
        product.setPart1("part1");
    }

    @Override
    public Product buildProduct() {
        return product;
    }
}
