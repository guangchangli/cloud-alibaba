package com.aldddin;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
public class EurekaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(EurekaConsumerApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

    @Autowired
    RestTemplate restTemplate;
    @LoadBalanced
    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }
    @GetMapping(value = "/consumer/hello")
    public String comsumerDemo(){
        String forObject = restTemplate.getForObject("http://eureka-provider/provider/hello", String.class);
        return forObject;
    }
    @HystrixCommand(fallbackMethod = "hiError")
    public String sayHi(String message){
        return restTemplate.getForObject("http://HELLO-SPRING-CLOUD-SERVICE-ADMIN/hi?message=" + message, String.class);
    }

    public String hiError(String message){
        return String.format("hi your message is %s but request error ",message);
    }
}
