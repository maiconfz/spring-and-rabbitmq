package io.github.maiconfz.spring_and_rabbitmq.repository;

import org.springframework.data.repository.CrudRepository;

import io.github.maiconfz.spring_and_rabbitmq.model.Msg;

public interface MsgRepository extends CrudRepository<Msg, Long> {
}
