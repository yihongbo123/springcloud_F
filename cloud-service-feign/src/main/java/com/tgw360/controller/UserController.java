package com.tgw360.controller;

import com.tgw360.entity.User;
import com.tgw360.hystrixclient.UserFeignHystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 易弘博 on 2018/3/27 18:03
 */
@RestController
@RequestMapping("/feign")
public class UserController {
    @Autowired
    private UserFeignHystrixClient userFeignHystrixClient;

    @GetMapping("/users")
    public List<User> findUsers(){
        return userFeignHystrixClient.findUserAll();
    }
}
