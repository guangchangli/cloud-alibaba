package com.aladdin.api.impl;

import com.aladdin.api.DemoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author lgc
 **/
@Service(interfaceName = "demoService",version = "1.0")
public class DemoServiceImpl implements DemoService {

    @Override
    public String helloDubbo() {
        return "hello dubbo";
    }
}
