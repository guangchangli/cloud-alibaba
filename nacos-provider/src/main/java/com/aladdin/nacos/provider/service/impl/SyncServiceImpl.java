package com.aladdin.nacos.provider.service.impl;

import com.aladdin.nacos.provider.service.SyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author lgc
 * @create 2020-02-28
 **/
@Service
public class SyncServiceImpl implements SyncService {
    @Async
    @Override
    public void helloSync() {
        try {
            Thread.sleep(3000);
            System.out.println("hello sync");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
