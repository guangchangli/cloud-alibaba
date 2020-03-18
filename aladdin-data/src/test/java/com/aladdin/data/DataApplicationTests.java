package com.aladdin.data;

import com.aladdin.data.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Date;

@SpringBootTest
class DataApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;
    @Test
    void contextLoads() {
    }
    @Test
    void mongoTest(){
        User user = new User();
        user.setId(2L);
        user.setName("毛姆");
        user.setPassword("123");
        user.setAddress("mm");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setPhone("15515605575");
        User insert = mongoTemplate.insert(user);
        System.out.println(insert);
    }

}
