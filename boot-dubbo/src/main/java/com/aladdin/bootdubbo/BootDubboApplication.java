package com.aladdin.bootdubbo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 引入 dubbo zkClient
 * 配置dubbo
 * @service dubbo 发布
 */
@SpringBootApplication
public class BootDubboApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BootDubboApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

}
