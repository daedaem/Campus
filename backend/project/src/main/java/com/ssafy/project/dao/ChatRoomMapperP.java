package com.ssafy.project.dao;

import java.util.List;

import com.ssafy.project.dto.ChatRoom;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatRoomMapperP {
	// 수정 필요
	int createRoom(ChatRoom newRoom);
	List<ChatRoom> getAllChatRooms();
	String getRoomTitle(long id);
	long getRoomId(String title);

}
