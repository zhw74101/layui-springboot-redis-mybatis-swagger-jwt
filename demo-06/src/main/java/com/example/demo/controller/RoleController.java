package com.example.demo.controller;

import com.example.demo.pojo.Role;
import com.example.demo.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhanghongwei on 2019/11/8.
 */
@Api(value = "处理角色",description = "角色信息")
@RestController
@RequestMapping("role")
public class RoleController {
    @Resource
    private RoleService roleService;

    @ApiOperation(value = "获取角色列表",notes = "不需要参数")
    @GetMapping("getrolelist")
    public List<Role> getRoleList(){
        List<Role> roles = roleService.getRoleList();
        return roles;
    }
}
