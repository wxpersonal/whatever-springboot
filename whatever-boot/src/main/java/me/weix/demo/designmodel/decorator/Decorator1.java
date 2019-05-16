package me.weix.demo.designmodel.decorator;

/**
 * @Author: weix
 * @Date: 2017/5/6
 * @Description:
 */
public class Decorator1 extends Decorator {

    public Decorator1(Human human) {
        super(human);
    }

    public void goClothespress() {
        System.out.println("去衣柜找找看。。");
    }

    public void findPlaceOnMap() {
        System.out.println("在Map上找找。。");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        goClothespress();
    }

    @Override
    public void walk() {
        super.walk();
        findPlaceOnMap();
    }
}

