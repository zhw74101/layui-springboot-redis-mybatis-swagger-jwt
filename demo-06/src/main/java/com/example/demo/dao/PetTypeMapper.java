package com.example.demo.dao;

import com.example.demo.pojo.PetType;

import java.util.List;

public interface PetTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PetType record);

    int insertSelective(PetType record);

    PetType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PetType record);

    int updateByPrimaryKey(PetType record);

    List<PetType> getAll();
}