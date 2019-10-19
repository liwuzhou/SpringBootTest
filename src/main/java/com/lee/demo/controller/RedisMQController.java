package com.lee.demo.controller;

import com.lee.demo.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class RedisMQController {

    @Autowired
    PublishService publishService;

    @GetMapping("/publishMessage")
    public String publishMessage(@PathParam("name") String name){
        String result = publishService.sendMessage(name);
        return  result;
    }
}
