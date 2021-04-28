package com.greedy.shortcut.messenger.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import net.sf.json.JSONObject;


@Component
public class MyHandler extends TextWebSocketHandler {

	private List<WebSocketSession> users;
	private Map<String, Object> userMap;
	
	public MyHandler() {
		users = new ArrayList<WebSocketSession>();
		userMap = new HashMap<String, Object>();
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("TextWebSocketHandler : 연결 생성");
		users.add(session);
	}
	
	
	protected void handlerTextMessgae(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("textWebSocketHandler : 메시지 수신!");
		System.out.println("메시지 : " + message.getPayload());
		JSONObject object = new JSONObject();
		String type = object.getString("type");
		
		if(type != null && type.equals("register")) {
			String user = object.getString("userId");
			userMap.put(user, session);
		} else { 
			String target = object.getString("target");
			WebSocketSession ws = (WebSocketSession) userMap.get(target);
			String msg = object.getString("message");
			if(ws != null) {
				ws.sendMessage(new TextMessage(msg));
			}
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("연결 종료!");
		users.remove(session);
	}
}
