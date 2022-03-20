package com.mrlu.spring.dao;

import com.mrlu.spring.domain.Goods;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-10 23:51
 */
public interface GoodsDao {
    //更新库存
    //goods表示本次用户购买的商品信息，id，购买数量
    int updateGoods(Goods goods);

    //查询商品的信息
    Goods selectGoods(Integer id);
}
