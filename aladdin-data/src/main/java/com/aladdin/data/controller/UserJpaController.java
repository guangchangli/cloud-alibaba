package com.aladdin.data.controller;

import com.aladdin.data.entity.User;
import com.aladdin.data.service.impl.UserJpaService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/jpa")
public class UserJpaController {
    @Autowired
    private UserJpaService userService;

    @GetMapping("/list")
    private String getUserById() {

        List<User> userList = userService.findAll();
        return JSON.toJSONString(userList);
    }
}