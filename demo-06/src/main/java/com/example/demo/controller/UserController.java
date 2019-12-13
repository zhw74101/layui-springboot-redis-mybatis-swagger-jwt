package com.example.demo.controller;

import com.example.demo.po.BasePage;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.vo.BaseResoult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhanghongwei on 2019/11/7.
 */
@Api(value = "管理用户",description = "对用户的操作")
@RestController
@RequestMapping("/user")
//@CacheConfig(cacheNames = "user")
public class UserController {
    @Resource
    private UserService userService;

//    @Cacheable(key = "123")
    @RequestMapping("getuserlist")
    @ApiOperation(value = "获取用户列表",notes = "不需要参数")
    public BaseResoult<User> getUserList(BasePage basePage){
        basePage.setPage((basePage.getPage()-1)*basePage.getLimit());
        List<User> list = userService.getUserList(basePage);
        //组装数据
        BaseResoult<User> baseResoult = new BaseResoult<>();
        baseResoult.setData(list);
        baseResoult.setCode(0);
        baseResoult.setCount(userService.getUserCount());
        baseResoult.setMsg("");
        return baseResoult;
    }

    @GetMapping("getuserbyid")
    @ApiOperation(value = "根据编号获取用户信息",notes = "需要用户编号")
    public User getUserById(long id){
        User user = userService.getUserById(id);
        return user;
    }

    @GetMapping("updateUser")
    @ApiOperation(value = "更新用户",notes = "更新部分数据")
    public BaseResoult updateUser(User user){
        //判断角色至少有一个
        BaseResoult baseResoult = new BaseResoult();
        int length = user.getRole().length();
        if(length <= 0){
            baseResoult.setCode(1);
            baseResoult.setMsg("员工至少需要一个角色！");
            return baseResoult;
        }
        int i = userService.updateUser(user);
        if(i > 0){
            baseResoult.setCode(0);
        }else{
            baseResoult.setCode(1);
            baseResoult.setMsg("更新出错了！");
        }
        return baseResoult;
    }

    @GetMapping("deleteUser")
    @ApiOperation(value = "删除用户",notes = "更新部分数据")
    @ApiParam(name = "编号",value = "id",required = true)
    public BaseResoult delUser(long id){
        int i = userService.delUser(id);
        BaseResoult baseResoult = new BaseResoult();
        if(i > 0){
            baseResoult.setCode(0);
        }else{
            baseResoult.setCode(1);
            baseResoult.setMsg("更新出错了！");
        }
        return baseResoult;
    }
}
