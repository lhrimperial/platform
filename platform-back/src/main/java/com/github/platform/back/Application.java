package com.github.platform.back;

import com.github.framework.starter.core.ApplicationContexts;
import com.github.framework.starter.core.FrameBootApplication;
import org.springframework.boot.SpringApplication;

/**
 *
 */
@FrameBootApplication(appName = "platform")
public class Application {

    public static void main(String[] args){
        ApplicationContexts.setProfileIfNotExists("dev");
        SpringApplication.run(Application.class, args);
    }
}
