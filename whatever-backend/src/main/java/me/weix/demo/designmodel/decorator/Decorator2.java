package me.weix.demo.designmodel.decorator;

/**
 * @Author: weix
 * @Date: 2017/5/6
 * @Description:
 */
public class Decorator2 extends Decorator {

    public Decorator2(Human human) {
        super(human);
    }

    public void findClothes() {
        System.out.println("找到一件D&G。。");
    }

    public void findTheTarget() {
        System.out.println("在Map上找到神秘花园和城堡。。");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        findClothes();
    }

    @Override
    public void walk() {
        super.walk();
        findTheTarget();
    }
}
