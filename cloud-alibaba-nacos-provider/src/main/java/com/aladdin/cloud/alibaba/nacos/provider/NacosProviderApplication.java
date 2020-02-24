package com.aladdin.cloud.alibaba.nacos.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgc
 * @create 2020-02-23
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication.class, args);
    }

    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String appName;

    @RestController
    public class EchoController {
        @GetMapping(value = "/echo/{message}")
        public String echo(@PathVariable(value = "message") String message) {
            return "Hello Nacos Discovery " + message + " i am from port " + port;
//            return "hello nacos "+message;
        }
    }
}
