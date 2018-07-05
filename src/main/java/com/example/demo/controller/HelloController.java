package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hurry
 * @date 2018/3/19
 **/
@RestController
@Slf4j
public class HelloController {
    @Autowired
    private UserMapper userMapper;

    @Value("${name}")
    private String name;
}
