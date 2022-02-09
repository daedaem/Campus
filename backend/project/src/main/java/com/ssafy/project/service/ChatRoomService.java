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
	public long createPersonalRoom(int sendId, int receiveId) {
		String connect = " 와 ";
		String senderNickname = chatroomMapper.getNickName(sendId);
		String title = senderNickname + connect;
		String receiverNickname = chatroomMapper.getNickName(receiveId);
		title = title + receiverNickname;
		chatroomMapper.insertMaster(sendId);
		long id = chatroomMapper.getChatId();

		return 0;
	}

	@Override
	public List<ChatRoom> getAllChatRooms(int userNo) {
		return chatroomMapper.getAllChatRooms(userNo);
	}

	@Override
	public String getRoomTitle(long mateNo) {
		return chatroomMapper.getRoomTitle(mateNo);
	}



}
