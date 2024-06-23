package com.rui.springboot_mall.service;

import com.rui.springboot_mall.dto.UserLoginRequest;
import com.rui.springboot_mall.dto.UserRegisterRequest;
import com.rui.springboot_mall.model.User;

public interface UserService {

    User getUserById(Integer userId);
    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);

}
