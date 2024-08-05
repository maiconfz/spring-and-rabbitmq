package io.github.maiconfz.spring_and_rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import io.github.maiconfz.spring_and_rabbitmq.config.QueueConfig;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ToStdOutReceiver {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "stdout", durable = "false"), exchange = @Exchange(value = QueueConfig.TOPIC_EXCHANGE_NAME, ignoreDeclarationExceptions = "true"), key = "stdout.#"))
    public void receiveMessage(String message) {
        log.info("msg received: {}", message);
    }
}
