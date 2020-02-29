package com.aladdin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
public class EurekaProviderApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(EurekaProviderApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

    @Value("${server.port}")
    private String port;
    @GetMapping("/provider/hello")
    public String providerDemo() {
        return "hello im provider from eureke server，port："+port;
    }
    //服务提供方-服务降级方法
    @RequestMapping("/excuteHystrixHandler")
    private String excuteHystrixHandler(){
        return "您好，当前系统人数较多，请稍后重试，给您带来的不便，敬请谅解！！！";
    }

}
