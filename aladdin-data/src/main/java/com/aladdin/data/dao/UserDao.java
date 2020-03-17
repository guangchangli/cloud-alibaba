package com.aladdin.data.dao;

import com.aladdin.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lgc
 */
public interface UserDao extends JpaRepository<User, Long> {
}