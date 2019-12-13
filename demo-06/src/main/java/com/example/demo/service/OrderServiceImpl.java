package com.example.demo.service;

import com.example.demo.dao.OrderMapper;
import com.example.demo.po.BasePage;
import com.example.demo.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhanghongwei on 2019/12/5.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Order> getOrderList(BasePage basePage) {
        return orderMapper.getAll();
    }

    @Override
    public int getOrderCount() {
        return orderMapper.getCount();
    }
}
