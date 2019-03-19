package me.weix.demo.designmodel.decorator;

/**
 * @Author: weix
 * @Date: 2017/5/6
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Human person = new Person();
        Decorator decorator = new Decorator2(new Decorator1(
                new Decorator0(person)));
        decorator.wearClothes();
        decorator.walk();

    }
}