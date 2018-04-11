package com.tgw360.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.bus.BusPathMatcher;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 易弘博 on 2018/3/27 14:43
 */
@RestController
@RefreshScope
public class TestController {
    @Value("${aaa.aaa}")
    private String value;

    @Value("${spring.cloud.bus.id}")
    private String id;

    @Value("${eureka.instance.instance-id}")
    private String instanceId;


    @RequestMapping("test")
    public String test(){
        return value;
    }
    @RequestMapping("id")
    public String id(){
        return id;
    }
}
