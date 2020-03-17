package com.aladdin.data.dao.mapper;

import com.aladdin.data.entity.User;

import java.util.List;

/**
 * @author lgc
 **/
public interface UserMapper {
    List<User> queryUserList();
}
