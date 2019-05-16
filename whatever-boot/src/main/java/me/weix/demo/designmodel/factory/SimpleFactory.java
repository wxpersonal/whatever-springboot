package me.weix.demo.designmodel.factory;


import me.weix.demo.designmodel.factory.model.Model1;
import me.weix.demo.designmodel.factory.model.Model2;

/**
 * 简单工厂
 * @Author: weix
 * @Date: 2017/4/24
 * @Description:
 */

public class SimpleFactory{

    public Object create(Class<?> clazz){

        if(clazz.getName().equals(Model1.class.getName())){
            return new Model1();
        }

        if(clazz.getName().equals(Model2.class.getName())){
            return new Model2();
        }

        return null;
    }

}
