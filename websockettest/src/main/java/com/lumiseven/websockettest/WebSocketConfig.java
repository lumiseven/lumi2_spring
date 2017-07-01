package com.lumiseven.websockettest;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/endpoint_test").withSockJS();//注册一个endpoint 并指定使用SockJS协议 broadcast 广播式
		registry.addEndpoint("/endpoint_test_chat").withSockJS();//注册一个endpoint 并指定使用SockJS协议
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/topic");//广播式需配置消息代理 此处/topic broadcast 广播式
		registry.enableSimpleBroker("/queue");//点对点式消息代理 point to point 点对点式
//		registry.enableSimpleBroker("/topic", "/queue");
	}
	
}
