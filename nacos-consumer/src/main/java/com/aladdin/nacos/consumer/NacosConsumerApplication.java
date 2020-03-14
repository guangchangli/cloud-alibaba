package com.aladdin.nacos.consumer;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosConsumerApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(NacosConsumerApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }



}
