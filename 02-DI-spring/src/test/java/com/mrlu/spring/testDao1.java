package com.mrlu.spring;

import com.mrlu.spring.dao1.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-09 15:33
 */
public class testDao1 {
    //给Student对象注入属性值
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("dao1/applicationContext.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("dao1/applicationContext.xml");
        Date date = context.getBean("date", Date.class);
        System.out.println(date);
    }
}
