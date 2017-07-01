package com.lumiseven.websockettest.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.lumiseven.websockettest.entity.DemoMessageFromClient;
import com.lumiseven.websockettest.entity.DemoMessageToClient;

@Controller
public class DemoController {
	
	@MessageMapping("/test_websocket")
	@SendTo("/topic/getResponse")
	public DemoMessageToClient messageToClient(DemoMessageFromClient dmfc) throws Exception{
		Thread.sleep(5000);
		DemoMessageToClient dmtc = new DemoMessageToClient();
		dmtc.setContent("test websocket message from server to client. conntent: " + dmfc.getContent());
		return dmtc;
	}
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	@MessageMapping("/chat")
	public void handleChat(Principal principal, String msg){
		if (principal.getName().equals("lumione")){
			messagingTemplate.convertAndSendToUser("lumitwo", "/queue/notifications", principal.getName() + " - send: " + msg);
		} else {
			messagingTemplate.convertAndSendToUser("lumione", "/queue/notifications", principal.getName() + " - send: " + msg);
		}
	}

}
