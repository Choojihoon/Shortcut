package com.greedy.shortcut.alarm.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Repository
public class WebSocketHandler extends TextWebSocketHandler {
	
	private AlarmMapper alarmMapper;
	
	@Autowired
	public WebSocketHandler(AlarmMapper alarmMapper) {
		this.alarmMapper = alarmMapper;
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
		
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		session.sendMessage(new TextMessage(alarmMapper.countReceiveNote(message.getPayload())));
		
	}
}
