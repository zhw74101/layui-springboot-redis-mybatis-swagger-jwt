package com.example.demo.pojo;

import java.util.Date;

public class Order {
    private Integer id;

    private String orderId;

    private Integer orderUserId;

    private Date orderCreateTime;

    private Integer orderState;

    private Date orderLastUpdateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(Integer orderUserId) {
        this.orderUserId = orderUserId;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Date getOrderLastUpdateTime() {
        return orderLastUpdateTime;
    }

    public void setOrderLastUpdateTime(Date orderLastUpdateTime) {
        this.orderLastUpdateTime = orderLastUpdateTime;
    }
}