package com.example.demo.dao;

import com.example.demo.pojo.PetUser;

public interface PetUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PetUser record);

    int insertSelective(PetUser record);

    PetUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PetUser record);

    int updateByPrimaryKey(PetUser record);
}