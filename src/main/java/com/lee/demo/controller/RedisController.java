package com.lee.demo.controller;

import com.lee.demo.service.impl.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    RedisService redisService;

    @GetMapping("redisTest")
    public String redisTest(){
        redisService.setKey("name","lee");
        redisService.setKey("age","28");

        String name = redisService.getValue("name");
        String age = redisService.getValue("age");
        return name + "--" + age;
    }
}
