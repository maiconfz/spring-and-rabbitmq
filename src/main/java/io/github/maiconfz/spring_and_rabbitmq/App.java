package io.github.maiconfz.spring_and_rabbitmq;

import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.maiconfz.spring_and_rabbitmq.publisher.ToStdOutPublisher;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner toStdOutRunner(final ToStdOutPublisher toStdOutPublisher) {
		return args -> IntStream.range(0, 100).parallel().forEach(i -> toStdOutPublisher.publish("Hello Queue " + i));
	}

}
