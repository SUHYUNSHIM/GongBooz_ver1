package com.suhyun.socket.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig {
	@Autowired
	private EchoHandler echoHandler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistery registry) {
		 registry.addHandler(echoHandler, "/echo")  .setAllowedOrigins("*")
	        .withSockJS()
	        .setClientLibraryUrl(
	          "https://cdn.jsdelivr.net/sockjs/latest/sockjs.min.js")
	        .setInterceptors(new HttpSessionHandshakeInterceptor());
	}
}
