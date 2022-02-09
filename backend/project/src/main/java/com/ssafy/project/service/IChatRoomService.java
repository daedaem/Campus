package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.dto.ChatRoom;

public interface IChatRoomService {
	long createRoom(ChatRoom newRoom);
	List<ChatRoom> getAllChatRooms(int userNo);
	String getRoomTitle(long id);

	long createPersonalRoom(int sendId, int receiveId);
}