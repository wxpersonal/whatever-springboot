package me.weix.demo.designmodel.factory;

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
