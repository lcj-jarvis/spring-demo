package com.mrlu.spring.dao3.impl;

import com.mrlu.spring.dao3.UserDao;
import com.mrlu.spring.domain.User;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-09 17:36
 */
public class OracleDaoImpl implements UserDao {
    @Override
    public void insertUser(User user) {
        System.out.println("成功插入"+user + "到oracle数据库");
    }
}
