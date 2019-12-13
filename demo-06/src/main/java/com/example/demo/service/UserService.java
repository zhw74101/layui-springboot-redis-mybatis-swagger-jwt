package com.example.demo.service;

import com.example.demo.po.BasePage;
import com.example.demo.pojo.User;

import java.util.List;

/**
 */
public interface UserService {

    List<User> getUserList(BasePage basePage);

    User getUserById(long id);

    int getUserCount();

    int updateUser(User user);

    int delUser(long id);

    User getUserByName(String name);
}
