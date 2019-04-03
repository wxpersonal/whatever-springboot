package me.weix.demo.designmodel.factory;

import me.weix.demo.designmodel.factory.model.Model;
import me.weix.demo.designmodel.factory.model.Model4;

/**
 * @Author: Wells.Wei
 * @Date: 2017/4/24
 * @Description:
 */
public class Model4FactoryMethod extends FactoryMethod {

    @Override
    public Model create() {
        return new Model4();
    }
}
