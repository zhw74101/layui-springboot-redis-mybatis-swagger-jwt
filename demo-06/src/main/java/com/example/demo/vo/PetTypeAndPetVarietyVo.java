package com.example.demo.vo;

import com.example.demo.pojo.PetVariety;

import java.util.List;

/**
 * Created by zhanghongwei on 2019/12/9.
 */
public class PetTypeAndPetVarietyVo {
    private Integer id;

    private String type;

    private List<PetVariety> list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<PetVariety> getList() {
        return list;
    }

    public void setList(List<PetVariety> list) {
        this.list = list;
    }
}
