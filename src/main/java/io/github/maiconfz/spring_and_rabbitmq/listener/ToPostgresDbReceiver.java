package io.github.maiconfz.spring_and_rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import io.github.maiconfz.spring_and_rabbitmq.config.QueueConfig;
import io.github.maiconfz.spring_and_rabbitmq.model.Msg;
import io.github.maiconfz.spring_and_rabbitmq.repository.MsgRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
@AllArgsConstructor
public class ToPostgresDbReceiver {

    private final MsgRepository msgRepository;

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "postgres", durable = "false"), exchange = @Exchange(value = QueueConfig.TOPIC_EXCHANGE_NAME, ignoreDeclarationExceptions = "true", type = "topic"), key = "postgres.#"))
    public void receiveMessage(Msg msg) {
        log.info("Saving msg to databse: {}", msg);
        final Msg savedMsg = this.msgRepository.save(msg);
        log.info("Msg saved: {}", savedMsg);
    }
}
