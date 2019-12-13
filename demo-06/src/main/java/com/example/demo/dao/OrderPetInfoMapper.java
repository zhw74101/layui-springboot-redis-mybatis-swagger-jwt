package com.example.demo.dao;

import com.example.demo.pojo.OrderPetInfo;

public interface OrderPetInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderPetInfo record);

    int insertSelective(OrderPetInfo record);

    OrderPetInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderPetInfo record);

    int updateByPrimaryKey(OrderPetInfo record);
}