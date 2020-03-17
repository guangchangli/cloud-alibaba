package com.aladdin.data.service;


import com.aladdin.data.entity.User;

import java.util.List;

/**
 * @author lgc
 */

public interface UserService {
    List<User> findAll();
}