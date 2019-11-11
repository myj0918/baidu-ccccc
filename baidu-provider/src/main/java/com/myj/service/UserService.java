package com.myj.service;

import com.myj.model.User;

import java.util.List;

public interface UserService {
    //熔断器
    List<User> findUserList();
}
