package com.example.demo.service;

import com.example.demo.po.BasePage;
import com.example.demo.pojo.Pet;

import java.util.List;

/**
 * Created by zhanghongwei on 2019/12/5.
 */
public interface PetService {

    List<Pet> getPetList(BasePage basePage);

    int getPetCount();
}
