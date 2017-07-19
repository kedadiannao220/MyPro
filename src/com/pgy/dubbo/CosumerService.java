package com.pgy.dubbo;

import main.java.dubbo.HelloWorldService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by admin on 10/07/2017.
 */
@SpringBootApplication
public class CosumerService {
 
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CosumerService.class, args);
        HelloWorldService bean = run.getBean(HelloWorldService.class);
        System.out.println(bean.sayHello("hello"));
    }
}
