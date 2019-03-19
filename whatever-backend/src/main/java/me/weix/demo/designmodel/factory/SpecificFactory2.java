package me.weix.demo.designmodel.factory;

import me.weix.demo.designmodel.factory.model.Model5;
import me.weix.demo.designmodel.factory.model.Model6;
import me.weix.demo.designmodel.factory.model.SpeciaficModel5_2;
import me.weix.demo.designmodel.factory.model.SpeciaficModel6_2;

/**
 * @Author: Wells.Wei
 * @Date: 2017/4/24
 * @Description:
 */
public class SpecificFactory2 implements AbstractFactory{

    @Override
    public Model5 getModel5() {
        return new SpeciaficModel5_2() ;
    }

    @Override
    public Model6 getModel6() {
        return new SpeciaficModel6_2() ;
    }
}
