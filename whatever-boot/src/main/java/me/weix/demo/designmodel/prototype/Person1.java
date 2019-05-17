package me.weix.demo.designmodel.prototype;

import java.util.List;

/**
 * @Author: Wells.Wei
 * @Date: 2017/5/2
 * @Description: 浅克隆
 */
public class Person1 implements Cloneable{
    private String name;
    private String sex;
    private List<String> hobbies;

    public Person1(String name, String sex, List<String> hobbies) {
        this.name = name;
        this.sex = sex;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public Person1 clone(){

        Person1 o = null;
        try {
            //这里为浅克隆
            o = (Person1) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}
