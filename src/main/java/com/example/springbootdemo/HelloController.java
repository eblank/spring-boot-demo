package com.example.springbootdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hurry
 * @date 2018/3/19
 **/
@RestController
public class HelloController {
    @Value("${name}")
    private String name;

    @GetMapping("/")
    public String hello() {
        return name;
    }
}
