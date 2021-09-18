package com.suhyun.socket.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
 
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler{
	private static List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	 	@Override  //해당 IP 포트로 클라이언트가 접속했을 때 실행되는 메소드.
	    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	        String user_name = searchUserName(session);
//	        for(WebSocketSession sess : sessionList) {
//	            sess.sendMessage(new TextMessage(user_name+"님이 접속했습니다."));
//	        }
	        sessionList.add(session);
	    }
	    
	    @Override //클라이언트가 메세지를 보냈을 때, 나타나는 메소드.
	    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	        String user_name= searchUserName(session);
	 
	        
//	        //사용자가 접속중인지 아닌지
//	        WebSocketSession chatwritingSession =users.get("user_name");
//	        if(chatwritingSession != null) {
//	            TextMessage textMessage = new TextMessage(user_name+ " 님이 메세지를 보냈습니다.");
//	            chatwritingSession.sendMessage(textMessage);
//	        }
	        for(WebSocketSession sess: sessionList) {
	            sess.sendMessage(new TextMessage(user_name+": "+message.getPayload()));
	        }
	    }
	    
	    @Override //연결이 끊어지면 실행되는 메소드.
	    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	        String user_name = searchUserName(session);
	        System.out.println("연결 끊어짐");
	        for(WebSocketSession sess : sessionList) {
	            sess.sendMessage(new TextMessage(user_name+"님의 연결이 끊어졌습니다."));
	        }
	        sessionList.remove(session);
	    }
	    
	    //세션 객체에 저장해둔 user_name을 가져와서 사용하려고 만든 메소드.
	    public String searchUserName(WebSocketSession session)throws Exception {
	        String user_name;
	        Map<String, Object> map;
	        map = session.getAttributes();
	        user_name = (String) map.get("user_name");
	        return user_name;
	    }
}
