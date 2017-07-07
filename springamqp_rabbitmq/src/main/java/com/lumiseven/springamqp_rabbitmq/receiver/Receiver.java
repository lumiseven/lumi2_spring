package com.lumiseven.springamqp_rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	
	@RabbitListener(queues = "test_queue")
	public void receiveMessage(String message){
		System.out.println("Received message: " + message);
	}

}
