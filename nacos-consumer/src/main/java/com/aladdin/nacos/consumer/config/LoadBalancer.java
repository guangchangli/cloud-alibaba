package com.aladdin.nacos.consumer.config;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author lgc
 **/
public interface LoadBalancer {
    ServiceInstance getSingleAddress(List<ServiceInstance> serviceInstances);
}
