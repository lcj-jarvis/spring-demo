package com.mrlu.spring.dao2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-09 20:12
 */

@Component("myStudent")
public class Student {


    /**
     *
     * @Value 简单类型的属性赋值
     * 属性：value是String类型的，表示简单类型的属性值
     *      可以出现在属性，方法上
     * 位置：1、在属性定义的上面，无需set方法也可以给属性赋值，推荐使用
     *      2、在set方法的上面
     *
     */
    //@Value(value = "jack")
    @Value("jack")
    private String name;
    //@Value(value = "18")
    @Value("18")
    private Integer age;

    public String getName() {
        return name;
    }

    /*@Value(value = "jack")
    public void setName(String name) {
        this.name = name;
    }*/

    public Integer getAge() {
        return age;
    }

    /*@Value(value = "18")
    public void setAge(Integer age) {
        this.age = age;
    }*/

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
