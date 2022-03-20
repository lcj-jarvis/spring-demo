package com.mrlu.spring.service.impl;

import com.mrlu.spring.dao3.UserDao;
import com.mrlu.spring.domain.User;
import com.mrlu.spring.service.UserService;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-09 17:14
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
       userDao.insertUser(user);
    }
}
