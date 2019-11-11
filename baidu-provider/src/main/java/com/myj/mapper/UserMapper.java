package com.myj.mapper;

import com.myj.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    //熔断器
    @Select("SELECT ur.userId,ur.userName from t_user ur")
    List<User> findUserList();
}
