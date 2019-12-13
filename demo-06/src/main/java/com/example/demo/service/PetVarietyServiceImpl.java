package com.example.demo.service;

import com.example.demo.dao.PetVarietyMapper;
import com.example.demo.pojo.PetVariety;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhanghongwei on 2019/12/9.
 */
@Service
public class PetVarietyServiceImpl implements PetVarietyService {
    @Autowired
    private PetVarietyMapper petVarietyMapper;

    @Override
    public List<PetVariety> getPetVarietyListByPetType(int typeId) {
        return petVarietyMapper.getPetVarietyListByPetType(typeId);
    }

    @Override
    public List<PetVariety> getPetVarietyListBefor10() {
        return petVarietyMapper.getPetVarietyListBefor10();
    }
}
