package com.mrlu.spring;

import com.mrlu.spring.service3.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-10 14:07
 */
public class TestService3 {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("service3/applicationContext.xml");
        SomeService proxy = context.getBean("someService", SomeService.class);

        proxy.doFirst("jack");
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("service3/applicationContext.xml");
        SomeService proxy = context.getBean("someService", SomeService.class);

        proxy.doSome();
    }
}
