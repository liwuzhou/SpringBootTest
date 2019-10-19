package com.lee.demo.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 */
@Component
public class FirstConsumer {

    @RabbitListener(queues = {"first-queue","second-queue"},containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage(String message){
        //消息处理
        System.out.println("FirstConsumer {} handleMessage :"+message);
    }

}
