package com.lumiseven.springjms_activemq.sender;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;

public class Msg implements MessageCreator{

	@Override
	public Message createMessage(Session session) throws JMSException {
		return session.createTextMessage("create test message");
	}

}
