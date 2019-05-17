package me.weix.demo.designmodel.decorator;

/**
 * @Author: weix
 * @Date: 2017/5/6
 * @Description: 装饰者
 */
public class Decorator implements Human {

    private Human human;
    public Decorator(Human human) {
        this.human = human;
    }

    @Override
    public void wearClothes() {
        human.wearClothes();
    }

    @Override
    public void walk() {
        human.walk();
    }
}
