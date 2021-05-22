package com.gs.common.example.service;

import com.gs.common.example.entity.User;
import com.gs.common.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:23
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User find(int id){
        return userMapper.find(id);
    }

    public User findById(int id){
        return userMapper.findById(id);
    }

    public void insert(int id, String userName, String passWord, String realName){
        userMapper.insert(id, userName, passWord, realName);
    }

    public void update(int id, String userName, String passWord, String realName){
        userMapper.update(id, userName, passWord, realName);
    }

    public void delete(int id){
        userMapper.delete(id);
    }

    public void postInsert(int id, String userName, String passWord, String realName){
        userMapper.insert(id, userName, passWord, realName);
    }

    public List<User> postList(){
        return userMapper.postList();
    }
}
