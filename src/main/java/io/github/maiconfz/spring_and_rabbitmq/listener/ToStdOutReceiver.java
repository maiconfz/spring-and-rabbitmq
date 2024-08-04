package io.github.maiconfz.spring_and_rabbitmq.listener;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ToStdOutReceiver {

    public void receiveMessage(String message) {
        log.info("msg received: {}", message);
    }
}
