package com.aladdin.data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lgc
 * @see org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages = {"com.aladdin.data.dao.mapper"})
public class AladdinDataApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AladdinDataApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

}
