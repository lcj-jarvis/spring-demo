package com.mrlu.spring.domain;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-10 23:13
 */
public class Sales {
    private Integer id;
    private Integer goodId;
    private Integer total;

    public Sales() {
    }

    public Sales(Integer goodId, Integer total) {
        this.goodId = goodId;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", goodId=" + goodId +
                ", total=" + total +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
