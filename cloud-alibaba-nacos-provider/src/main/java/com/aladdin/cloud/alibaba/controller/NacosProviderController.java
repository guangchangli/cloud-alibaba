package com.aladdin.cloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgc
 * @create 2020-02-23
 **/
@RestController
public class NacosProviderController {

    @GetMapping(value = "/echo/{message}")
    public String echo(@PathVariable(value = "message") String message){
        return "hello nacos"+message;
    }
}
