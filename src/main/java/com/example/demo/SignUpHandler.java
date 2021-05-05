package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Waterball (johnny850807@gmail.com)
 */
@Slf4j
@Configuration
public class SignUpHandler {
    public static final String QUEUE = "queue";
    private final RestTemplate restTemplate = new RestTemplate();

    public SignUpHandler(@Value("${spring.rabbitmq.host}") String rabbitMqHost,
                         ServerProperties serverProperties) {
        log.info("RabbitMQ's host: {}", rabbitMqHost);
    }

    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }

    @RabbitListener(queues = QUEUE)
    public void handle(String signUpUserId) {
        int id = Integer.parseInt(signUpUserId);
        User user = restTemplate.getForEntity("http://localhost:8080/api/users/" + id, User.class).getBody();
        log.info("Handle sign-up: {}", user);
    }
}
