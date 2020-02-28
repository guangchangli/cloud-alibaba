package com.aladdin.nacos.provider.service.impl;

import com.aladdin.nacos.provider.service.ScheduleService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lgc
 * @create 2020-02-28
 **/
@Service
public class ScheduleServiceImpl implements ScheduleService {

    /**
     * second, minute, hour, day of month, month, day of week
     * 0 * * * * MON-FRI 周一到周五
     */
    @Scheduled(cron="0 * * * * MON-FRI")
    public void scheduleHello() {
        System.out.println("0 * * * * MON-FRI out now is "+ new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
    }
}
