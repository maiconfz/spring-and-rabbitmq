package io.github.maiconfz.spring_and_rabbitmq.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import io.github.maiconfz.spring_and_rabbitmq.config.QueueConfig;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@Component
public class ToStdOutPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publish(String msg) {
        this.rabbitTemplate.convertAndSend(QueueConfig.TOPIC_EXCHANGE_NAME, "stdout.info", msg);
    }
}
