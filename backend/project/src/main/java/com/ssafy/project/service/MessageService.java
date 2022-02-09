package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.dao.MessageMapper;
import com.ssafy.project.dto.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class MessageService implements IMessageService {
	
    @Autowired
    MessageMapper messageMapper;

	@Override
	public int insertMessage(Message chatMessage) {
		return messageMapper.insertMessage(chatMessage);
	}

	@Override
	public List<Message> getMessagesByChatroomTitle(String title, long idx) {
		return messageMapper.getMessagesByChatroomTitle(title, idx);
	}

}
