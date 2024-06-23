package com.rui.springboot_mall.controller;

import com.rui.springboot_mall.dto.UserLoginRequest;
import com.rui.springboot_mall.dto.UserRegisterRequest;
import com.rui.springboot_mall.model.User;
import com.rui.springboot_mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("users/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest){

        Integer userId = userService.register(userRegisterRequest);

        User user = userService.getUserById(userId);

        return  ResponseEntity.status(HttpStatus.CREATED).body(user);

    }


    @PostMapping("users/login")
    public  ResponseEntity<User> login(@RequestBody @Valid UserLoginRequest userLoginRequest){
        User user = userService.login(userLoginRequest);

        return ResponseEntity.status(HttpStatus.OK).body(user);

    }
}
