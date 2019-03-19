package me.weix.demo.designmodel.adapter;


/**
 * @Author: weix
 * @Date: 2017/5/2
 * @Description:  将一个类的接口转换成客户希望的另一个接口
 *                适配器模式让那些接口不兼容的类可以一起工作
 */
public class Test {

    public static void main(String[] args){

        // 使用特殊功能类，即适配类
        Target adapter = new Adapter();
        adapter.request();
        adapter.specificRequest();

    }
}


