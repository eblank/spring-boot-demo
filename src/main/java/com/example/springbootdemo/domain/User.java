package com.example.springbootdemo.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hurry
 * @date 2018/3/28
 **/
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
