package com.greetings.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication(exclude = { ActiveMQAutoConfiguration.class })
@Log4j2
public class Application {
	public static void main(String[] args) {
		try {
			SpringApplication.run(Application.class, args);
		} catch (Exception exception) {
			log.error("[App] could not launch greetings app.", exception);
		}
	}
}
