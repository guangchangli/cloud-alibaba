package com.aladdin.nacos.provider.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lgc
 **/
@Configuration
public class RedissonConfig {
    @Bean
    public Redisson redisson(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setPassword("redis@4.0").setDatabase(0);
        return (Redisson) Redisson.create(config);
    }
}
