package com.example.demo.service;

import com.example.demo.dao.PetTypeMapper;
import com.example.demo.dao.PetVarietyMapper;
import com.example.demo.pojo.PetType;
import com.example.demo.pojo.PetVariety;
import com.example.demo.vo.PetTypeAndPetVarietyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanghongwei on 2019/12/9.
 */
@Service
public class PetTypeImpl implements PetTypeService {
    @Autowired
    private PetTypeMapper petTypeMapper;

    @Autowired
    private PetVarietyMapper petVarietyMapper;

    @Override
    public List<PetTypeAndPetVarietyVo> getAll() {
        List<PetTypeAndPetVarietyVo> list = new ArrayList<>();
        List<PetType> petTypeList = petTypeMapper.getAll();
        //遍历获取
        for(PetType petType : petTypeList){
            List<PetVariety> petVarieties = petVarietyMapper.getPetVarietyListByPetType(petType.getId());
            PetTypeAndPetVarietyVo petTypeAndPetVarietyVo = new PetTypeAndPetVarietyVo();
            petTypeAndPetVarietyVo.setList(petVarieties);
            petTypeAndPetVarietyVo.setId(petType.getId());
            petTypeAndPetVarietyVo.setType(petType.getType());
            list.add(petTypeAndPetVarietyVo);
        }
        return list;
    }
}
