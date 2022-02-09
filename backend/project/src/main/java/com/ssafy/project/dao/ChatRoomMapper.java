package com.ssafy.project.dao;

import java.util.List;

import com.ssafy.project.dto.ChatRoom;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatRoomMapper {

	int createRoom(ChatRoom newRoom);
	List<ChatRoom> getAllChatRooms(int userNo);
	String getRoomTitle(long mateNo);

	int createPersonalRoom(int sendId, int receiveId);

	String getNickName(int userNo);

	void insertMaster(int sendId);

	int getChatId();


}
