package com.aladdin.nacos.provider.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lgc
 **/
@Component
public class WebConfig implements WebMvcConfigurer {

    /**
     * 跨域支持 同源策略(协议，域名，端口)
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                //所有网站可以进行访问
                .allowedOrigins("*")
                //
                .allowCredentials(true)
                //允许 get ... 外域请求
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                //时间内不在发送预检
                .maxAge(3600 * 24)
                //允许包含 content-type 头
                .allowedHeaders("content-type");
    }
}
