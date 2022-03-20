package com.mrlu.spring.service.impl;

import com.mrlu.spring.service.HelloSpring;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-09 14:15
 */
public class HelloSpringImpl implements HelloSpring {
    public HelloSpringImpl() {
        System.out.println("1、加载配置文件的时候创建对象");
    }

    @Override
    public void sayHello() {
        System.out.println("HelloSpring");
    }
}
