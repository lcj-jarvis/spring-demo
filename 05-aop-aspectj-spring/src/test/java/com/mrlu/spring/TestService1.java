package com.mrlu.spring;

import com.mrlu.spring.service1.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-10 14:07
 */
public class TestService1 {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("service1/applicationContext.xml");
        //从容器中获取目标对象
        SomeService proxy = context.getBean("someService", SomeService.class);
        //com.sun.proxy.$Proxy6:jdk的动态代理。实际上就是代理类对象
        /*
        在配置文件中加入了这个就是表示采用cglib代理
        <aop:aspectj-autoproxy proxy-target-class="true"></aop:aspectj-autoproxy>
         */
        System.out.println(proxy.getClass().getName());
        //通过代理对象执行方法，实现目标方法执行时，增强了功能
        proxy.doSome("jack",20);
    }
}
