package com.aladdin.cloud.alibaba.feign.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lgc
 * @create 2020-02-24
 **/

@FeignClient(value = "nacos-provider")
public interface NacosProviderService {
    @GetMapping(value = "/echo/{message}")
    String echo(@PathVariable(value = "message") String message);
}
