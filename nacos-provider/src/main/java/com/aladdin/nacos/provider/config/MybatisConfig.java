package com.aladdin.nacos.provider.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lgc
 **/
@Configuration
public class MybatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setMapUnderscoreToCamelCase(true);
    }
}
