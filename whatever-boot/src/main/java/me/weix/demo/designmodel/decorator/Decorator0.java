package me.weix.demo.designmodel.decorator;

/**
 * @Author: weix
 * @Date: 2017/5/6
 * @Description:
 */
public class Decorator0 extends Decorator {

    public Decorator0(Human human){
        super(human);
    }

    public void goHome(){
        System.out.println("进房子。。");
    }

    public void findMap(){
        System.out.println("书房找找Map。。");
    }

    @Override
    public void wearClothes(){
        super.wearClothes();
        goHome();
    }

    @Override
    public void walk(){
        super.walk();
        findMap();
    }
}
