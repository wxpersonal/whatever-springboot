package me.weix.demo.designmodel.factory;

import com.wx.designmodel.factory.model.Model5;
import com.wx.designmodel.factory.model.Model6;

/**
 * @Author: Wells.Wei
 * @Date: 2017/4/24
 * @Description: 抽象工厂
 *               抽象工厂和工厂方法没有本质区别，是对工厂方法的扩展。
 *               当产品类，涉及到多个产品簇时，需要对同类的产品抽象为一个接口。工厂类中，可以定义多个返回具体产品的方法，自由组合。
 */
public interface AbstractFactory {

    public Model5 getModel5();

    public Model6 getModel6();
}
