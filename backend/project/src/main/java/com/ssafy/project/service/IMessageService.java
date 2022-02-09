package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.dto.Message;

public interface IMessageService {
	int insertMessage(Message chatMessage);
	List<Message> getMessagesByChatroomTitle(String title, long idx);
}