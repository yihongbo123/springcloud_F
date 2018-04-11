package com.tgw360.service;

import com.tgw360.entity.User;
import com.tgw360.mapper.master.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 易弘博 on 2018/3/27 10:37
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> findAll(){
        return userMapper.findAll();
    }
}
