package com.lee.demo.rabbitmq.config;

import com.lee.demo.rabbitmq.mqcallback.MsgSendConfirmCallBack;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置
 */
@Configuration
public class RabbitMqConfig {

    @Autowired
    private ExchangeConfig exchangeConfig;
    @Autowired
    private QueueConfig queueConfig;
    @Autowired
    ConnectionFactory connectionFactory;

    // 消息交换机的名字
    public static final String EXCHANGE = "exchangeTest";
    //队列key1
    public static final String ROUTINGKEY1 = "queue-one-key1";
    //队列key2
    public static final String ROUTINGKEY2 = "queue-one-key2";


    /**
     * 将消息队列1和交换机进行绑定
     * @return
     */
    @Bean
    public Binding binding_one(){
        return BindingBuilder.bind(queueConfig.firstQueue())
                .to(exchangeConfig.directExchange())
                .with(ROUTINGKEY1);
    }

    /**
     * 将消息队列2和交换机进行绑定
     * @return
     */
    @Bean
    public Binding binding_two(){
        return BindingBuilder.bind(queueConfig.secondQueue())
                .to(exchangeConfig.directExchange())
                .with(ROUTINGKEY2);
    }

    /**
     * 配置消息监听，当消息到达时，会通知监听在对应的队列上的监听对象
     * @return
     */
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer_one(){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer(connectionFactory);
        simpleMessageListenerContainer.addQueues(queueConfig.firstQueue());
        simpleMessageListenerContainer.setExposeListenerChannel(true);
        simpleMessageListenerContainer.setMaxConcurrentConsumers(5);
        simpleMessageListenerContainer.setConcurrentConsumers(1);
        //设置确认模式为手工确认
        simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return simpleMessageListenerContainer;
    }

    /**
     * 定义RabbitTemplate用于消息的发送和接收
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate(){

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        /**若使用confirm-callback或return-callback，
         * 必须要配置publisherConfirms或publisherReturns为true
         * 每个rabbitTemplate只能有一个confirm-callback和return-callback
         */
        rabbitTemplate.setConfirmCallback(msgSendConfirmCallBack());
        return rabbitTemplate;
    }

    /**
     * 消息确认机制
     * @return
     */
    @Bean
    public MsgSendConfirmCallBack msgSendConfirmCallBack(){
        return new MsgSendConfirmCallBack();
    }

}
