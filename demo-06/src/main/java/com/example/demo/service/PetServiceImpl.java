package com.example.demo.service;

import com.example.demo.dao.PetMapper;
import com.example.demo.po.BasePage;
import com.example.demo.pojo.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhanghongwei on 2019/12/5.
 */
@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetMapper petMapper;

    @Override
    public List<Pet> getPetList(BasePage basePage) {
        return petMapper.getAll();
    }

    @Override
    public int getPetCount() {
        return petMapper.getCount();
    }
}
