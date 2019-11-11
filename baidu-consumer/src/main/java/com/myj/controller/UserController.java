package com.myj.controller;

import com.myj.model.User;
import com.myj.service.UserServiceFeign;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
public class UserController {
    @Resource
    private UserServiceFeign userServiceFeign;
    /**
    * @Description:    java类作用描述
    * @Author:         门玉杰
    * @CreateDate:     2019/11/11 8:50
    * @UpdateUser:     yc
    * @UpdateDate:     2019/11/11 8:50
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    //测试框架是否可用
    @RequestMapping("/test")
    public  void test(){
         userServiceFeign.test();
    }
    //熔断器
    @RequestMapping("/findUserList")
    public List<User> findUserList(HttpServletResponse response) throws IOException {
        List<User> userList = userServiceFeign.findUserList();
        if(userList == null){
            /* 设置格式为text/json */
            response.setContentType("text/json");
            /* 设置字符集为'UTF-8' */
            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.write("网络异常！！！");
            printWriter.flush();
            printWriter.close();
        }
        return userList;
    }
    @RequestMapping("/getUserName")
    public String getUserName(){
        return userServiceFeign.getUserName();
    }
}
