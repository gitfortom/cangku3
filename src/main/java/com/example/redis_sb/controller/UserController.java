package com.example.redis_sb.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.redis_sb.domain.User;
import com.example.redis_sb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/getAllUser")
    public List<User> getAllUser(){
        return userMapper.selectList(null);
    }
    /*
    路径参数方式
     */
    @RequestMapping("/getUserById/{uid}")
    public User getUserById( @PathVariable("uid")Integer uid){
        //User user = userMapper.selectOne(new QueryWrapper<User>().eq("uid",1));
        User user = userMapper.selectById(uid);
        return user;
    }
    /*
    Query参数方式
     */
    @RequestMapping("/getUserById")
    public User getUserByIdParam(Integer uid){
        //User user = userMapper.selectOne(new QueryWrapper<User>().eq("uid",1));
        User user = userMapper.selectById(uid);
        return user;
    }

    @RequestMapping("/insertUser")
    public String insertUser(@RequestBody User user){
        System.out.println(user);
        userMapper.insert(user);
        return "添加用户成功";
    }

    @RequestMapping("/updatetUser")
    public String updatetUser(@RequestBody User user){
        //UpdateWrapper<User> wrapper = new UpdateWrapper<>();

        //userMapper.update(user,wrapper.eq("uid",30).set("uname","王二狗").set("usex","公的"));
        userMapper.updateById(user);
        //userMapper.update(user,new QueryWrapper<User>().eq("uid",30));
        return "修改用户成功";
    }
    @RequestMapping("/deleteUserById/{id}")
    public void deleteUserById(@PathVariable("id") Integer id){
        userMapper.deleteById(id);
        System.out.println("删除用户成功");
    }
}
