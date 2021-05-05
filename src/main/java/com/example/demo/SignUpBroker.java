package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Waterball (johnny850807@gmail.com)
 */
@Slf4j
@Configuration
public class SignUpBroker {

    public static final String QUEUE = "queue";

    public SignUpBroker(@Value("${spring.rabbitmq.host}") String rabbitMqHost) {
        log.info("RabbitMQ's host: {}", rabbitMqHost);
    }

    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }

    @RabbitListener(queues = QUEUE)
    public void handle(String signUpMessage) {
        log.info(signUpMessage);
    }
}
