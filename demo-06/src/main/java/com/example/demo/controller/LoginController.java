package com.example.demo.controller;

import com.example.demo.annotations.PassToken;
import com.example.demo.annotations.UserLoginToken;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.JWTUtil;
import com.example.demo.vo.BaseResoult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by zhanghongwei on 2019/11/11.
 */
@Api(value = "验证JWT",description = "验证jwtToken验证")
@RestController
@RequestMapping("user")
public class LoginController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "测试登录获取jwt")
    @PostMapping("/login")
//    @PassToken
    public BaseResoult login(String name,String password){
        BaseResoult baseResoult = new BaseResoult();
        User userForBase=userService.getUserByName(name);
        if(userForBase==null){
            baseResoult.setCode(1);
            baseResoult.setMsg("登录失败,用户不存在");
            return baseResoult;
        }else {
            if (!userForBase.getUserpassword().equals(password)){
                baseResoult.setCode(1);
                baseResoult.setMsg("登录失败,密码错误");
                return baseResoult;
            }else {
                String token = JWTUtil.getToken(userForBase);
                baseResoult.setToken(token);
                baseResoult.setCode(0);
                baseResoult.setMsg("登陆成功");
                return baseResoult;
            }
        }
    }

    @ApiOperation(value="登录去验证jwt")
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}
