package com.pgy.dubbo;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;

import main.java.dubbo.HelloWorldService;

/**
 * Created by admin on 10/07/2017.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = CosumerService.class)
@Component
public class Client {

    @Reference(version = "1.0.0")
    public HelloWorldService helloWorldService;

}
