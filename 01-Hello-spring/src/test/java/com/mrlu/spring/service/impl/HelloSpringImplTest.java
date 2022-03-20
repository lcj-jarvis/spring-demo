package com.mrlu.spring.service.impl;

import com.mrlu.spring.service.HelloSpring;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-09 14:24
 */

public class HelloSpringImplTest {



    @Test
    public void sayHello() {
        //使用spring容器创建对象
        //1、指定配置文件的路径
        String config = "beans.xml";
        //2、创建表示Spring容器的对象，ApplicationContext
        //ApplicationContext就是表示Spring容器，通过容器获取对象
        //ClassPathXmlApplicationContext:表示从类路径【即target/classes目录下】加载Spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        System.out.println("2、创建对象完成之后");
        //从容器中获取对象，你调用对象的方法。
        //第一种方式getBean("配置文件中bean对象的id值")
        //HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
        //第一种方式getBean("配置文件中bean对象的id值",对象的类型)
        HelloSpring helloSpring = context.getBean("helloSpring", HelloSpringImpl.class);

        //调用spring创建好的对象的方法
        helloSpring.sayHello();
    }

    /**
     * spring默认创建对象的时间：在创建spring容器的时候，会创建配置文件中的所有对象
     * spring创建对象调用的无参构造
     */
    @Test
    public void createTime(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //构造方法执行了两次，由此可见，在创建spring容器的时候，会创建配置文件中的所有对象
        /*
         1、加载配置文件的时候创建对象
         1、加载配置文件的时候创建对象
        */
    }

    /**
     * 获取spring容器中的java对象信息
     */
    @Test
    public void getCount(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //调用getBeanDefinitionCount方法获取容器中对象的个数
        int count = context.getBeanDefinitionCount();
        System.out.println("容器中对象的个数："+count);
        //获取容器中对象的id值
        String[] names = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(names));

    }

    /**
     * spring容器创建非自定义类型
     */
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Date date = context.getBean("date", Date.class);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-EEE HH:mm:ss SSS");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }
}
