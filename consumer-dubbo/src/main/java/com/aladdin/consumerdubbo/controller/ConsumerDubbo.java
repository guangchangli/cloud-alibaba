package com.aladdin.consumerdubbo.controller;

import com.aladdin.consumerdubbo.Service.ConsumerService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgc
 * @create 2020-02-28
 **/
@RestController
@RequestMapping("/dubbo")
public class ConsumerDubbo {

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/consumer")
    public String consumer() {
        return JSON.toJSONString(consumerService.consumerBook());
    }
}
