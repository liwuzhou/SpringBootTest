package com.lee.demo.mq;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * 消息订阅者配置类
 */

@Configuration
@AutoConfigureAfter({Receiver.class})
public class SubscriberConfig {

    /**
     * 消息监听适配器，注入接受消息方法，输入方法名字 反射方法
     *
     * @param receiver
     * @return
     */
    @Bean
    public MessageListenerAdapter getMessageListenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "onMessage"); //当没有继承MessageListener时需要写方法名字
    }


    /**
     * 创建消息监听容器
     *
     * @param redisConnectionFactory
     * @param messageListenerAdapter
     * @return
     */
    @Bean
    public RedisMessageListenerContainer getRedisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListenerAdapter) {
        //新建消息监听容器
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        //消息监听容器设置一个redis连接工厂
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        //消息监听容器中设置消息监听配置器
        redisMessageListenerContainer.addMessageListener(messageListenerAdapter, new PatternTopic("TOPIC_USERNAME"));
        return redisMessageListenerContainer;
    }

}
