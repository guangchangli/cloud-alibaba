package com.aladdin.nacos.provider;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class NacosProviderApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    void contextLoads() {
    }

    @Test
    void testRedis(){
        stringRedisTemplate.opsForValue().set("name","李广昌");

    }

}
