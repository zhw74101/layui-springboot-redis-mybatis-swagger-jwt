package com.example.demo.dao;

import com.example.demo.pojo.PetVariety;

import java.util.List;

public interface PetVarietyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PetVariety record);

    int insertSelective(PetVariety record);

    PetVariety selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PetVariety record);

    int updateByPrimaryKey(PetVariety record);

    List<PetVariety> getPetVarietyListByPetType(int typeId);

    List<PetVariety> getPetVarietyListBefor10();
}