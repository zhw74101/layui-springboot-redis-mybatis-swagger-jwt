package com.example.demo.controller;

import com.example.demo.po.BasePage;
import com.example.demo.pojo.Order;
import com.example.demo.pojo.Pet;
import com.example.demo.service.OrderService;
import com.example.demo.service.PetService;
import com.example.demo.vo.BaseResoult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhanghongwei on 2019/12/5.
 */
@RestController
@RequestMapping("order")
@Api(value = "订单相关操作",description = "管理员操作")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("getuserlist")
    @ApiOperation(value = "获取宠物列表",notes = "不需要参数")
    public BaseResoult<Order> getUserList(BasePage basePage){
        basePage.setPage((basePage.getPage()-1)*basePage.getLimit());
        List<Order> list = orderService.getOrderList(basePage);
        //组装数据
        BaseResoult<Order> baseResoult = new BaseResoult<>();
        baseResoult.setData(list);
        baseResoult.setCode(0);
        baseResoult.setCount(orderService.getOrderCount());
        baseResoult.setMsg("");
        return baseResoult;
    }
}
