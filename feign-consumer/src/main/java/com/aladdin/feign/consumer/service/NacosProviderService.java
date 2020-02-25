package com.aladdin.feign.consumer.service;

import com.aladdin.feign.consumer.service.feedback.NacosProviderFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-provider", fallback = NacosProviderFallBack.class)
public interface NacosProviderService {


    @GetMapping(value = "/echo/{message}")
    String echo(@PathVariable("message") String message);
}