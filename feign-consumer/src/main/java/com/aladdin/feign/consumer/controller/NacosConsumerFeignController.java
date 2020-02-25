package com.aladdin.feign.consumer.controller;

import com.aladdin.feign.consumer.service.NacosProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosConsumerFeignController {

    @Autowired
    private NacosProviderService nacosProviderService;

    @GetMapping(value = "/echo/hi")
    public String echo() {
        return nacosProviderService.echo("Hi Feign");
    }
}