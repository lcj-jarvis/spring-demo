package com.mrlu.spring.service.impl;

import com.mrlu.spring.dao.GoodsDao;
import com.mrlu.spring.dao.SalesDao;
import com.mrlu.spring.domain.Goods;
import com.mrlu.spring.domain.Sales;
import com.mrlu.spring.excption.NotEnoughException;
import com.mrlu.spring.service.GoodsService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-11 0:05
 */
//@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
  //  @Autowired
    private GoodsDao goodsDao;
   // @Autowired
    private SalesDao salesDao;

    //注入批量执行的sqlsession
    @Autowired
    private SqlSession sqlSession;
    /**
     *
     * rollbackFor 表示发生指定的异常一定回滚
     *   rollbackFor = {异常列表}
     *   处理的逻辑是
     *   (1)spring框架会首先检查方法抛出的异常是不是在rollbackFor的属性值中
     *      如果异常在rollbackFor列表中，不管是什么类型的异常，一定回滚
     *  （2）如果你抛出的异常不在rollbackFor列表中，spring就会判断异常是不是RuntimeException类型的
     *      如果是一定回滚
     */
    /*@Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {
                    NullPointerException.class,NotEnoughException.class
            }
    )*/
    @Transactional
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
