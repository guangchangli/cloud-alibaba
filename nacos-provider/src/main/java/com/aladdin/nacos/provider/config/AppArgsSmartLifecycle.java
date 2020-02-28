package com.aladdin.nacos.provider.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class AppArgsSmartLifecycle implements SmartLifecycle {

    private boolean isRunning=false;

    private final ApplicationArguments applicationArguments;

    public AppArgsSmartLifecycle(ApplicationArguments applicationArguments) {
        this.applicationArguments = applicationArguments;
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable runnable) {
        runnable.run();
    }

    @Override
    public void start() {
        System.out.println("--------------------AppArgsSmartLifecycle--Start()------------------------------");

        System.out.println(applicationArguments);
        if (applicationArguments!=null){
            System.out.println(applicationArguments.getNonOptionArgs());
        }

        isRunning=true;
    }

    @Override
    public void stop() {
        isRunning=false;

    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public int getPhase() {
        return Integer.MAX_VALUE;
    }
}