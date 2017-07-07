package com.lumiseven.springjms_activemq.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	
	@JmsListener(destination = "destination1")
	public void receiveMessage(String message){
		System.out.println("receive message: " + message);
	}

}
