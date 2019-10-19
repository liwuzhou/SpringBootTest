package com.lee.demo.rabbitmq.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息交换机配置
 */
@Configuration
public class ExchangeConfig {

    @Bean
    public DirectExchange directExchange(){
        DirectExchange directExchange = new DirectExchange(RabbitMqConfig.EXCHANGE,true,false);
        return directExchange;
    }
}
