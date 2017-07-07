package com.lumiseven.springamqp_rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringamqpRabbitmqApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringamqpRabbitmqApplication.class, args);
	}

	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Bean
	public Queue wiselyQueue(){
		return new Queue("test_queue");
	}
	
	@Override
	public void run(String... args) throws Exception {
		rabbitTemplate.convertAndSend("test_queue", "message from rabbitmq");
	}
}
