package com.aladdin.feign.consumer.service.feedback;

import com.aladdin.feign.consumer.service.NacosProviderService;
import org.springframework.stereotype.Component;

/**
 * @author lgc
 * @create 2020-02-25
 **/
@Component
public class NacosProviderFallBack implements NacosProviderService {
    @Override
    public String echo(String message) {
        return "请求失败，请检查网络";
    }
}
