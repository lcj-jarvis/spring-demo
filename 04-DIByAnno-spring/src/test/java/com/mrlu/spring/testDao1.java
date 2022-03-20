package com.mrlu.spring;

import com.mrlu.spring.dao1.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-09 20:31
 */
public class testDao1 {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("dao1/applicationContext.xml");
        Student student = context.getBean("myStudent", Student.class);
        System.out.println(student);
    }
}
