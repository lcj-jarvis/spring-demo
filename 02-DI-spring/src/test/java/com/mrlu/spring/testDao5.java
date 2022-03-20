package com.mrlu.spring;

import com.mrlu.spring.dao5.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-09 19:22
 */
public class testDao5 {

    @Test
    public void test1(){
        //注意：这个时候加载的是主配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("dao5/total.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }
}
