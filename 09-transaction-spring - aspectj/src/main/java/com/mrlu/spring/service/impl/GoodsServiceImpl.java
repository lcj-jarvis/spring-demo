package com.mrlu.spring.service.impl;

import com.mrlu.spring.dao.GoodsDao;
import com.mrlu.spring.dao.SalesDao;
import com.mrlu.spring.domain.Goods;
import com.mrlu.spring.domain.Sales;
import com.mrlu.spring.excption.NotEnoughException;
import com.mrlu.spring.service.GoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-11 0:05
 */

public class GoodsServiceImpl implements GoodsService {

    private GoodsDao goodsDao;
    private SalesDao salesDao;


    @Override
    public void buyGoods(Integer goodsId, Integer num) {
        System.out.println("=========buy方法开始==========");
        //一次操作
        //1、添加销售记录
        Sales sales = new Sales(goodsId,num);
        salesDao.insertSales(sales);
        //2、更新库存
        Goods goods = goodsDao.selectGoods(goodsId);
        //把if语句写这里，是为了看出现异常的时候，上面的添加销售记录有没有成功
        if (goods == null){
            throw new NullPointerException("编号是:"+goodsId+"的商品不存在");
        }else if(goods.getAmount() < num){
            throw new NotEnoughException("编号是:"+goodsId+"的商品库存不足");
        }

        //两次操作
        //修改库存
        goods = new Goods();
        goods.setId(goodsId);
        goods.setAmount(num);
        goodsDao.updateGoods(goods);
        System.out.println("=========buy方法结束==========");

    }

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public SalesDao getSalesDao() {
        return salesDao;
    }

    public void setSalesDao(SalesDao salesDao) {
        this.salesDao = salesDao;
    }
}
