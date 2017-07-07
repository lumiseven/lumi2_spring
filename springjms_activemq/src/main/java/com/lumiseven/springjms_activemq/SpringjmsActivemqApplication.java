package com.lumiseven.springjms_activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

import com.lumiseven.springjms_activemq.sender.Msg;

@SpringBootApplication
public class SpringjmsActivemqApplication implements CommandLineRunner{//spring boot 提供commandLineRunner借口，用于程序启动后执行的代码，通过重写run方法执行

	public static void main(String[] args) {
		SpringApplication.run(SpringjmsActivemqApplication.class, args);
	}

	@Autowired
	JmsTemplate jmsTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		jmsTemplate.send("destination1", new Msg());
	}
}
