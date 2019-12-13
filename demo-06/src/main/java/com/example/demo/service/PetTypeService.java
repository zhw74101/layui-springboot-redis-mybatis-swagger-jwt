package com.example.demo.service;

import com.example.demo.vo.PetTypeAndPetVarietyVo;

import java.util.List;

/**
 * Created by zhanghongwei on 2019/12/9.
 */
public interface PetTypeService {
    public List<PetTypeAndPetVarietyVo> getAll();
}
