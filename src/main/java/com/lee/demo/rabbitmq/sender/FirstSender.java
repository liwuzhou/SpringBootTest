package com.lee.demo.rabbitmq.sender;

import com.lee.demo.rabbitmq.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息生产者
 */
@Component("firstSender")
public class FirstSender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param uuid
     * @param message
     */
    public void send(String uuid,Object message){
        CorrelationData correlationData = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE,RabbitMqConfig.ROUTINGKEY2,message,correlationData);
    }
}
