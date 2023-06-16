package com.nxy.excel_demo.service.impl;

import com.nxy.excel_demo.entity.User;
import com.nxy.excel_demo.mapper.UserMapper;
import com.nxy.excel_demo.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/6/15 16:56
 * @description
 **/

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private UserMapper userMapper;


    @Override
    public int saveUser(User user) {
        return userMapper.insert(user);
    }


}
