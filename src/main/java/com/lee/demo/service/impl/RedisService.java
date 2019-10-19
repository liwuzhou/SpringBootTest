package com.lee.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public  void setKey(String key,String value){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(key,value,1, TimeUnit.MINUTES);//1分钟过期
    }

    public String getValue(String key){
        ValueOperations<String, String> ops = this.redisTemplate.opsForValue();
        return ops.get(key);
    }

}
