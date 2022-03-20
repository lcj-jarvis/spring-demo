package com.mrlu.spring;

import com.mrlu.spring.service2.SomeService;
import com.mrlu.spring.service2.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-10 14:07
 */
public class TestService2 {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("service2/applicationContext.xml");
        SomeService proxy = context.getBean("someService", SomeService.class);

        //通过代理对象执行方法，实现目标方法执行时，增强了功能
        proxy.doOther("jack",20);
      //  Student student = proxy.newStudent();
      //  System.out.println("最终获取到的结果"+student);
    }
}
