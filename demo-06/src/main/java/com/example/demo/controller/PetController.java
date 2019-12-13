package com.example.demo.controller;

import com.example.demo.po.BasePage;
import com.example.demo.pojo.Pet;
import com.example.demo.pojo.PetType;
import com.example.demo.pojo.PetVariety;
import com.example.demo.pojo.User;
import com.example.demo.service.PetService;
import com.example.demo.service.PetTypeService;
import com.example.demo.service.PetVarietyService;
import com.example.demo.vo.BaseResoult;
import com.example.demo.vo.PetTypeAndPetVarietyVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhanghongwei on 2019/12/5.
 */
@RestController
@RequestMapping("pet")
@Api(value = "宠物相关操作",description = "管理员操作")
public class PetController {
    @Autowired
    private PetService petService;

    @Autowired
    private PetVarietyService petVarietyService;

    @Autowired
    private PetTypeService petTypeService;


    @RequestMapping("getuserlist")
    @ApiOperation(value = "获取宠物列表",notes = "不需要参数")
    public BaseResoult<Pet> getUserList(BasePage basePage){
        basePage.setPage((basePage.getPage()-1)*basePage.getLimit());
        List<Pet> list = petService.getPetList(basePage);
        //组装数据
        BaseResoult<Pet> baseResoult = new BaseResoult<>();
        baseResoult.setData(list);
        baseResoult.setCode(0);
        baseResoult.setCount(petService.getPetCount());
        baseResoult.setMsg("");
        return baseResoult;
    }

    @RequestMapping("getPetTypeListByPetType")
    @ApiOperation(value = "获取宠物类别列表",notes = "根据宠物类别")
    public BaseResoult<PetVariety> getPetTypeListByPetType(@RequestParam("pettype") String pettype){
        int typeid = 1;
        BaseResoult baseResoult = new BaseResoult();
        //判断类型
        if(pettype.equals("index")){
            //随便出10个类型
            baseResoult.setData(petVarietyService.getPetVarietyListBefor10());
            baseResoult.setCode(1);
            return baseResoult;
        }else if(pettype.equals("dog")){
            //
            baseResoult.setData(petVarietyService.getPetVarietyListByPetType(1));
            return baseResoult;
        }else{
            baseResoult.setData(petVarietyService.getPetVarietyListByPetType(2));
            return baseResoult;
        }
    }

//    @RequestMapping("getPetTypeListByPetTypeId")
//    @ApiOperation(value = "根据类型编号获取宠物类别列表",notes = "根据宠物类别编号")
//    public BaseResoult<PetVariety> getPetTypeListByPetTypeId(@RequestParam("typeId") int typeId){
//        BaseResoult baseResoult = new BaseResoult();
//
//        baseResoult.setData(petVarietyService.getPetVarietyListByPetType(typeId));
//        return baseResoult;
//    }

    @RequestMapping("getPetTypeList")
    @ApiOperation(value = "获取宠物首页左侧类别列表",notes = "无参数")
    public BaseResoult<PetTypeAndPetVarietyVo> getPetTypeList(){
        BaseResoult baseResoult = new BaseResoult();
        List<PetTypeAndPetVarietyVo> list = petTypeService.getAll();
        baseResoult.setData(list);
        return baseResoult;
    }


}
