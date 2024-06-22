package com.rui.springboot_mall.service.Impl;

import com.rui.springboot_mall.dao.UserDao;
import com.rui.springboot_mall.dto.UserRegisterRequest;
import com.rui.springboot_mall.model.User;
import com.rui.springboot_mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }
}
