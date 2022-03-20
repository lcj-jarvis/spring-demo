package com.mrlu.spring.service1;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-10 13:24
 */
//目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        //增加功能，在doSome方法之前之前，输出执行时间
        System.out.println("======doSome======");
    }
}
