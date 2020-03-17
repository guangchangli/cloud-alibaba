package com.aladdin.data.controller;

import com.aladdin.data.entity.User;
import com.aladdin.data.service.impl.UserMybatisService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lgc
 **/
@RestController
@RequestMapping("/user/mybatis")
public class UserMybatisController {

    @Autowired
    UserMybatisService userMybatisService;

    @GetMapping("/list")
    public String userList() {
        List<User> userList = userMybatisService.findAll();
        return JSON.toJSONString(userList);
    }
}
