package com.aladdin.nacos.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/cors")
public class CorsController {

    @GetMapping("/test")
    public String locale(Locale locale) {
        return "Hello";
    }
}