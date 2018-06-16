package com.arijeet.examples.apiversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = { RabbitAutoConfiguration.class })
@Configuration
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
