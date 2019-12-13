package com.example.demo.service;

import com.example.demo.pojo.PetVariety;

import java.util.List;

/**
 * Created by zhanghongwei on 2019/12/9.
 */
public interface PetVarietyService {
    public List<PetVariety> getPetVarietyListByPetType(int typeId);

    public List<PetVariety> getPetVarietyListBefor10();
}
