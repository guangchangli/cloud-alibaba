package com.aladdin.data.service.impl;

import com.aladdin.data.dao.mapper.UserMapper;
import com.aladdin.data.entity.User;
import com.aladdin.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lgc
 **/
@Service
public class UserMybatisService implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> findAll() {
        return userMapper.queryUserList();
    }
}
