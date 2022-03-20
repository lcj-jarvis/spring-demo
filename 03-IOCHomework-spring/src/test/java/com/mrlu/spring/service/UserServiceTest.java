package com.mrlu.spring.service;

import com.mrlu.spring.domain.User;
import com.mrlu.spring.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-09 17:23
 */
public class UserServiceTest {

    @Test
    public void addUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user = context.getBean("user", User.class);
        userService.addUser(user);
    }
}
