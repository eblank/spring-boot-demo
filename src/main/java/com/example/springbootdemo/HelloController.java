package com.example.springbootdemo;

import com.example.springbootdemo.domain.User;
import com.example.springbootdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author hurry
 * @date 2018/3/19
 **/
@RestController
public class HelloController {
    @Autowired
    private UserMapper userMapper;

    @Value("${name}")
    private String name;

    @RequestMapping("/index")
    public String hello() {
        return "hello word. " + name;
    }

    @RequestMapping("/insert")
    public User insert() {
        User user = new User();
        user.setUsername("zhangSan");
        user.setPassword("111");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
        return user;
    }
}
