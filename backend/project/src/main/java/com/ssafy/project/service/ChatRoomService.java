package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.dao.ChatRoomMapper;
import com.ssafy.project.dto.ChatRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ChatRoomService implements IChatRoomService {
	
    @Autowired
    ChatRoomMapper chatroomMapper;

	@Override
	public long createRoom(ChatRoom newRoom) {
		int result = chatroomMapper.createRoom(newRoom);
		return result == 1 ? newRoom.getId() : -1;
	}

	@Override
	public List<ChatRoom> getAllChatRooms() {
		return chatroomMapper.getAllChatRooms();
	}

	@Override
	public String getRoomTitle(long id) {
		return chatroomMapper.getRoomTitle(id);
	}

}
