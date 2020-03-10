package com.aladdin.nacos.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
@EnableScheduling
@MapperScan(basePackages = {"com.aladdin.nacos.provider.dao"})
public class NacosProviderApplication {
    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String appName;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(NacosProviderApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }


    @RestController
    public class EchoController {
        @GetMapping(value = "/echo/{message}")
        public String echo(@PathVariable(value = "message") String message) {
            return "Hello Nacos Discovery " + message + " i am from port " + port;
        }
    }


}
