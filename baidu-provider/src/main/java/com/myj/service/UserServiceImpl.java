package com.myj.service;

import com.myj.mapper.UserMapper;
import com.myj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    private UserMapper userMapper;

    //熔断器
    @Override
    public List<User> findUserList() {
        return userMapper.findUserList();
    }
}
