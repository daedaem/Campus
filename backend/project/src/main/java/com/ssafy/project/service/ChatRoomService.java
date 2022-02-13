package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.dao.ChatRoomMapper;
import com.ssafy.project.dao.MessageMapper;
import com.ssafy.project.dto.ChatRoom;
import com.ssafy.project.dto.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ChatRoomService implements IChatRoomService {
	
    @Autowired
    ChatRoomMapper chatroomMapper;

	@Autowired
	MessageMapper messageMapper;

	@Override
	public long createRoom(ChatRoom newRoom) {
		int result = chatroomMapper.createRoom(newRoom);
		return result == 1 ? newRoom.getId() : -1;
	}
	
	@Override
	public int checkReceiverRoom(int sendId, int receiveId) {
		int result = -1;
		// receiver가 sender와 방이 있는지
		int count1 = chatroomMapper.checkCountReceiver(sendId, receiveId);
		// sender가 receiver와 방이 있는지//
		int count2 = chatroomMapper.checkCountSender(sendId, receiveId);
		System.out.println(count1);
		System.out.println(count2);
		if(count1 == 0 && count2 == 0){ // 아무방도 없을때
			result = 0;
		}else if(count1 == 1 && count2 == 0){
			int set = chatroomMapper.checkReceiverRoom(sendId, receiveId);
			result = set;
		}else{
			int set = chatroomMapper.checkSenderRoom(sendId, receiveId);
			result = set;
		}
		return result;
	}

	@Override
	public long createPersonalRoom(int sendId, int receiveId) {
		String connect = " 와 ";
		String senderNickname = chatroomMapper.getNickName(sendId);
		String receiverNickname = chatroomMapper.getNickName(receiveId);
		String title = senderNickname + connect + receiverNickname;
		// 채팅방 생성
		ChatRoom room = new ChatRoom();
		room.setMasterId(sendId);
		room.setTitle(title);
		chatroomMapper.createPersonalRoom(room);

		// 채팅을 건 사람을 채팅에 참여 시킴
		Message message = new Message();
        message.setChatroomId(chatroomMapper.getRoomId(title));// 채팅방 아이디를 가져와야함
        message.setSenderId(sendId);
        message.setContent(senderNickname +"님이 참가하셨습니다.");
        messageMapper.insertMessage(message);

		// 채팅을 받는 사람을 참여 시킴
        message.setChatroomId(chatroomMapper.getRoomId(title));// 채팅방 아이디를 가져와야함
        message.setSenderId(receiveId);
        message.setContent(receiverNickname +"님이 참가하셨습니다.");
        messageMapper.insertMessage(message);
		
		return 1;
	}

	@Override
	public List<ChatRoom> getAllChatRooms(int userNo) {
		return chatroomMapper.getAllChatRooms(userNo);
	}

	@Override
	public String getRoomTitle(long mateNo) {
		return chatroomMapper.getRoomTitle(mateNo);
	}

	@Override
	public int deletePersonalRoom(int id) {
		chatroomMapper.deletePersonalRoom(id);
		return 1;
	}

	@Override
	public int deleteMyMessage(int id, int sendId) {
		chatroomMapper.deleteMyMessage(id, sendId);
		return 1;
	}





}
