package me.weix.demo.designmodel.factory;

import com.wx.designmodel.factory.model.Model5;
import com.wx.designmodel.factory.model.Model6;
import com.wx.designmodel.factory.model.SpeciaficModel5_1;
import com.wx.designmodel.factory.model.SpeciaficModel6_1;

/**
 * @Author: Wells.Wei
 * @Date: 2017/4/24
 * @Description:
 */
public class SpecificFactory1 implements AbstractFactory{

    @Override
    public Model5 getModel5() {
        return new SpeciaficModel5_1();
    }

    @Override
    public Model6 getModel6() {
        return new SpeciaficModel6_1();
    }
}
