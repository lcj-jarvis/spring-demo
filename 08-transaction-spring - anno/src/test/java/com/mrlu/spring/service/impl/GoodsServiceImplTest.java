package com.mrlu.spring.service.impl;

import com.mrlu.spring.excption.NotEnoughException;
import com.mrlu.spring.service.GoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-11 0:24
 */
public class GoodsServiceImplTest {

    @Test
    public void buyGoods() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GoodsService goodsService = context.getBean("goodsService", GoodsService.class);
        goodsService.buyGoods(1001,10);
    }
}
