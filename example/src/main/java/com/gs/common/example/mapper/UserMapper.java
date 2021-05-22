package com.gs.common.example.mapper;

import com.gs.common.example.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
@Repository
public interface UserMapper {

    User find(int id);

    @Select("select * from user where id = #{id}")
    User findById(int id);

    void insert(int id, String userName, String passWord, String realName);

    void update(int id, String userName, String passWord, String realName);

    void delete(int id);

    List<User> postList();
}
