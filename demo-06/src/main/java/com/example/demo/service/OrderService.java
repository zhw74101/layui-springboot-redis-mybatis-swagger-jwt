package com.example.demo.service;

import com.example.demo.po.BasePage;
import com.example.demo.pojo.Order;

import java.util.List;

/**
 * Created by zhanghongwei on 2019/12/5.
 */
public interface OrderService {
    List<Order> getOrderList(BasePage basePage);

    int getOrderCount();
}
