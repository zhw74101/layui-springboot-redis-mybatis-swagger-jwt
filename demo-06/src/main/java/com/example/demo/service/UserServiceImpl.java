package com.example.demo.service;

import com.example.demo.dao.RoleMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.enums.RoleEnum;
import com.example.demo.po.BasePage;
import com.example.demo.pojo.Role;
import com.example.demo.pojo.User;
import com.example.demo.utils.DateFormatUtil;
import com.example.demo.vo.BaseResoult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 */
@Service
public class UserServiceImpl implements  UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }


    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<User> getUserList(BasePage basePage) {
        List<User> list = userMapper.getUserList(basePage);
        for(User user : list){
            user.setUserpassword("****");
            //获取角色信息
            String roles[] = user.getRole().split(",");
            StringBuffer sb = new StringBuffer("");
            for(String str : roles){
                sb.append(RoleEnum.getRoleNameById(Integer.parseInt(str)));
                sb.append(",");
            }
            user.setRole(sb.toString().substring(0,sb.toString().lastIndexOf(",")));
            try {
                user.setBirthday(DateFormatUtil.dateFormat(user.getBirthday()));
            }catch (Exception e){

            }
        }
        //获取角色

        return list;
    }

    @Override
    public User getUserById(long id) {
        User user = userMapper.selectByPrimaryKey(id);

        try {
            user.setBirthday(DateFormatUtil.dateFormat(user.getBirthday()));
        }catch (Exception e){

        }
        //获取角色
        String[] roles = user.getRole().split(",");
        List<Role> roleList = new ArrayList<>();
        //根据编号查询角色
        for(int i = 0 ; i < roles.length ; i++){
            Role role = roleMapper.selectByPrimaryKey(Integer.parseInt(roles[i]));
            if(role!= null ){
                role.setLAY_CHECKED(true);
                roleList.add(role);
            }
        }
        user.setRoles(roleList);
        return user;
    }

    @Override
    public int getUserCount() {
        return userMapper.getCount();
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int delUser(long id) {
        return userMapper.deleteByPrimaryKey(id);
    }
}
