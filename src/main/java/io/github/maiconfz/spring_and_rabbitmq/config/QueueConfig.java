package io.github.maiconfz.spring_and_rabbitmq.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    public static final String TOPIC_EXCHANGE_NAME = "app-queue-exchange";
}
