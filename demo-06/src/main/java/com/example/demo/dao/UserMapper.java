package com.example.demo.dao;

import com.example.demo.po.BasePage;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> getUserList(BasePage basePage);

    int getCount();

    int updateUser(User user);

    User getUserByName(String name);
}