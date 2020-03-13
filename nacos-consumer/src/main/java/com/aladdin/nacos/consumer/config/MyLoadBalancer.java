package com.aladdin.nacos.consumer.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lgc
 **/
@Component
public class MyLoadBalancer implements LoadBalancer {

    //    private LongAdder longAdder=new LongAdder();
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 从注册中心拿到服务列表 本地实现负载均衡 轮询
     *
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance getSingleAddress(List<ServiceInstance> serviceInstances) {
//        longAdder.increment();
        int i = atomicInteger.incrementAndGet();
        return serviceInstances.get(i % serviceInstances.size());
    }
}
