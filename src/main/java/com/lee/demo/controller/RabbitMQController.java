package com.lee.demo.controller;

import com.lee.demo.rabbitmq.sender.FirstSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.UUID;

@RestController
public class RabbitMQController {

    @Autowired
    FirstSender firstSender;

    @GetMapping("/rabbitmqSend")
    public String sendMessage(@PathParam("message") String message){
        String uuid = UUID.randomUUID().toString();
        firstSender.send(uuid,message);
        return uuid;
    }
}
