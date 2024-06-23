package com.rui.springboot_mall.dao;

import com.rui.springboot_mall.dto.UserRegisterRequest;
import com.rui.springboot_mall.model.User;

public interface UserDao {

    User getUserById(Integer UserId);

    User getUserByEmail(String email);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
