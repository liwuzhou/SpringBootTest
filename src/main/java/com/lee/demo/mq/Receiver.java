package com.lee.demo.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class Receiver implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public void onMessage(Message message, byte[] bytes) {

        RedisSerializer<String> valueSerializer = redisTemplate.getStringSerializer();
        String deserialize = valueSerializer.deserialize(message.getBody());

        logger.info("收到的mq消息是：" + deserialize);

    }
}
