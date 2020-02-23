package com.aladdin.cloud.alibaba.nacos.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lgc
 * @create 2020-02-23
 **/
@RestController
public class NacosConsumerController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Value("${spring.application.name}")
    String appName;

    public String echo() {
        ServiceInstance instance = loadBalancerClient.choose("nacos-provider-a");
        String url = String.format("http://%s:%s/echo%s", instance.getHost(), instance.getPort(), appName);
        return restTemplate.getForObject(url, String.class);
    }
}
