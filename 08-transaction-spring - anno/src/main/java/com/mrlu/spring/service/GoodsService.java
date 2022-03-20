package com.mrlu.spring.service;

import com.mrlu.spring.excption.NotEnoughException;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-11 0:04
 */
public interface GoodsService {
    //购买商品的方法，goodsId商品的id，num为购买的数量
    void buyGoods(Integer goodsId,Integer num) throws NotEnoughException;
}
