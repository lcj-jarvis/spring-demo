package com.mrlu.spring.dao4;

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

    public Student() {
        System.out.println("====student=====");
    }

    //使用配置注入
    @Value("${stuName}")
    private String name;

    @Value("${stuAge}")
    private Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
