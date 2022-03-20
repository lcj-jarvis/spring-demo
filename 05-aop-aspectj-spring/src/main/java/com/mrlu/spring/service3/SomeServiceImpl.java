package com.mrlu.spring.service3;


/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-10 13:24
 */
//目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("======doSome======");
        int i = 10 / 0;
    }

    @Override
    public String doFirst(String name) {
        return name;
    }

}
