package com.aladdin.nacos.consumer.controller;

import com.aladdin.nacos.consumer.config.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class NacosConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;
    @Autowired
    LoadBalancer loadBalancer;
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping(value = "/echo/app/name")
    public String echo() {
        //使用 LoadBalanceClient 和 RestTemplate 结合的方式来访问
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        List<ServiceInstance> instances = discoveryClient.getInstances("nacos-provider");
        ServiceInstance singleAddress = loadBalancer.getSingleAddress(instances);
        System.out.println(singleAddress);
        //@LoadBalanced 默认就负载均衡 ribbon
        String forObject = restTemplate.getForObject("http://", String.class);
        String url = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(), serviceInstance.getPort(), appName);
        return restTemplate.getForObject(url, String.class);
    }
}