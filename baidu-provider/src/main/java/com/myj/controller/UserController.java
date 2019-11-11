package com.myj.controller;

import com.myj.model.User;
import com.myj.service.UserService;
import com.myj.service.UserServiceFeign;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController implements UserServiceFeign {
    @Resource
    private UserService userService;

    @Value("${1904b.api-b.777}")
    String  name;
    @Override
    public String getUserName() {
        System.out.println("调用生产者成功");
        return name;
    }

    @Override
    public void test() {
        System.out.println("框架可用");
    }
    //熔断器
    @GetMapping("findUserList")
    @Override
    public List<User> findUserList() {
        return userService.findUserList();
    }


}
