package com.aladdin.nacos.provider.controller.sync;

import com.aladdin.nacos.provider.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgc
 * @create 2020-02-28
 **/
@RestController
@RequestMapping("/sync")
public class SyncController {

    @Autowired
    SyncService syncService;

    @GetMapping("/hello")
    public String helloSync() {
        syncService.helloSync();
        return HttpStatus.OK.getReasonPhrase();
    }
}
