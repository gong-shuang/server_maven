package com.gs.common.example.controller;

import com.gs.common.example.entity.ResponseData;
import com.gs.common.example.entity.User;
import com.gs.common.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 14:42
 */

@RestController
@RequestMapping("/test")
public class UserController extends BaseController  {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String index() {
        return"Hello World";
    }

    @RequestMapping("/{id}")
    public User getUser(@PathVariable("id") int id) {
        return new User(id,"2323", "1232312","12412312");
    }

    @RequestMapping("user/findById/{id}")
    public String findById(@PathVariable int id){
        return userService.findById(id).toString();
    }

    @RequestMapping("user/get/{id}")
    public String GetUser(@PathVariable int id){
        return userService.find(id).toString();
    }

    @RequestMapping("user/set/{id}")
    public String SetUser(@PathVariable int id){
        userService.insert(id, "111", "222", "2222");
        return "ok";
    }

    @RequestMapping("user/update/{id}")
    public String update(@PathVariable int id){
        userService.update(id, "33", "3333", "3333");
        return "ok";
    }

    @RequestMapping("user/delete/{id}")
    public String delete(@PathVariable int id){
        userService.delete(id);
        return "ok";
    }

    @PostMapping("userPost/insert")
    public String postInsert(@RequestBody User user){
        userService.postInsert(user.getId(), user.getUserName(), user.getPassWord(), user.getRealName());
        return "ok";
    }

    @PostMapping("userList")
    public String postList(){
        return userService.postList().toString();
    }

    @PostMapping("userListJson")
    public ResponseData postListJson(){
        return successResponse(userService.postList());
    }
}
