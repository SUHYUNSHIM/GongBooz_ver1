package com.gb.chat.handler;

import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.CloseStatus;

public class ReplyEchoHandler extends TextWebSocketHandler {
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception{
		//커넥션 연결 
	}
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
		//메시지 보낼 떄 
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
		//연결끊기
	}

	

}
