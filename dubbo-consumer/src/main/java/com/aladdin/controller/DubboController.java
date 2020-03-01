package com.aladdin.controller;

import com.aladdin.api.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgc
 **/
@RestController
@RequestMapping("/dubbo")
public class DubboController {

    @Reference(version = "1.0",url = "dubbo://127.0.0.1:12345")
    DemoService demoService;

    @GetMapping("/consumer")
    public String testDubbo(){
        return demoService.helloDubbo();
    }
}
