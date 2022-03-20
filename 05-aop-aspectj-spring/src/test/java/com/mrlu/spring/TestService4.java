package com.mrlu.spring;

import com.mrlu.spring.service4.SomeServiceImpl;
import org.aspectj.lang.annotation.Aspect;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-10 14:07
 */
@Aspect
public class TestService4 {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("service4/applicationContext.xml");
        SomeServiceImpl proxy = context.getBean("someService", SomeServiceImpl.class);
        proxy.doSome();
        /*
        没有接口的时候使用cglib的代理方式
        com.mrlu.spring.service4.SomeServiceImpl$$EnhancerBySpringCGLIB$$57f7feb1
         */
        System.out.println(proxy.getClass().getName());

    }
}
