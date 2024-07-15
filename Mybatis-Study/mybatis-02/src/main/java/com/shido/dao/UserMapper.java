package com.shido.dao;

import com.shido.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {


    // 查询全部用户
    List<User> getUserList();

    // 根据ID查询用户
    User getUserById(int id);


    // 插入用户
    int addUser(User user);

    // 添加用户
    void addUser(int i, String 攻陷之神, String number);

    // 修改用户
    int updateUser(User user);

    // 删除用户
    int deleteUser(int id);
}
