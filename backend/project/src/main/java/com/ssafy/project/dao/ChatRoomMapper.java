package com.ssafy.project.dao;

import java.util.List;

import com.ssafy.project.dto.ChatRoom;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatRoomMapper {

	int createRoom(ChatRoom newRoom);
	List<ChatRoom> getAllChatRooms();
	String getRoomTitle(long mateNo);

}
