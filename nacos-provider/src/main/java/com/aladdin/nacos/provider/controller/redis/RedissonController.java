package com.aladdin.nacos.provider.controller.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author lgc
 **/
@RestController
public class RedissonController {

    @Autowired
    Redisson redisson;

    public void test() {
        /**
         * redisson 创建新的线程 在锁的三分之一的时间去判断是否还持有锁 进行续命
         * 其他线程自旋等待获取锁
         */
        String lockKey = "name";
        RLock lock = redisson.getLock(lockKey);
        try {
            lock.tryLock(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();


    }
}
