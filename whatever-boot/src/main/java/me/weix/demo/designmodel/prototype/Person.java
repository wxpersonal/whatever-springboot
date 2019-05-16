package me.weix.demo.designmodel.prototype;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author: Wells.Wei
 * @Date: 2017/5/2
 * @Description: 深克隆
 */
public class Person implements Cloneable{
    private String name;
    private String sex;
    private List<String> hobbies;

    public Person(String name, String sex, List<String> hobbies) {
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
    public Person clone(){

        Person o = null;
        try {
            //这里为浅克隆
            o = (Person) super.clone();

            //深克隆需要单独处理引用对象（Integer ，String除外）
            List<String> hobbies = Lists.newArrayList();
            for (String hobby : this.hobbies) {
                hobbies.add(hobby);
            }
            o.setHobbies(hobbies);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}
