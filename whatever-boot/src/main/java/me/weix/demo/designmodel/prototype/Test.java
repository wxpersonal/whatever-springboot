package me.weix.demo.designmodel.prototype;

import com.google.common.collect.Lists;

/**
 * @Author: weix
 * @Date: 2017/4/25
 * @Description:
 */
public class Test implements Cloneable{

    public static void main(String[] args) {
        Person p1 = new Person("weix", "男", Lists.newArrayList("movie", "music", "game"));
        Person1 p2 = new Person1("weix", "男", Lists.newArrayList("movie", "music", "game"));

        Person pp1 = (Person) p1.clone();
        System.out.println(p1 == pp1);
        System.out.println(p1.getHobbies() == pp1.getHobbies());


        Person1 pp2 =  p2.clone();
        System.out.println(p2 == pp2);
        System.out.println(p2.getHobbies() == pp2.getHobbies());

    }
}
