package com.lee.demo.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 队列配置，可配置多个队列
 */
@Configuration
public class QueueConfig {

    /**
     * durable:true  rabbitmq重启的时候不需要创建新的队列
     * exclusive:false 该消息队列是否只在当前connection生效，默认false
     * autoDelete:false 该消息队列在没有被使用时将被自动删除，默认 false
     */
    @Bean
    public Queue firstQueue(){
        return new Queue("first-queue",true,false,false);
    }

    @Bean
    public Queue secondQueue(){
        return new Queue("second-queue",true,false,false);
    }
}
