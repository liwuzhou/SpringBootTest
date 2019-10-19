package com.lee.demo.service.impl;

import com.lee.demo.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service("publishService")
public class PublishServiceImpl implements PublishService {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public String sendMessage(String name) {
        try {
            redisTemplate.convertAndSend("TOPIC_USERNAME",name);
            return "消息发送成功";
        }catch (Exception e){
            return "消息发送失败";
        }
    }
}
