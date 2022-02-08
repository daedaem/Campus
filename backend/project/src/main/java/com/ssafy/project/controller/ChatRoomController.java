package com.ssafy.project.controller;

import java.util.List;

import com.ssafy.project.dto.ChatRoom;
import com.ssafy.project.dto.Message;
import com.ssafy.project.service.IChatRoomService;
import com.ssafy.project.service.IMessageService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@RestController
public class ChatRoomController {

	private final IChatRoomService chatroomService;
	private final IMessageService messageService;
	final int PAGE = 10;

	// 특정 채팅방 타이틀 가져오기
	@GetMapping("/room/{id}")
	public ResponseEntity<String> roomTitle(@PathVariable long mateNo) {
		String roomTitle = chatroomService.getRoomTitle(mateNo);
		if (roomTitle == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

		return ResponseEntity.status(HttpStatus.OK).body(roomTitle);
	}

	// 모든 채팅방 목록 반환
	@GetMapping("/rooms")
	public ResponseEntity<List<ChatRoom>> room() {
		List<ChatRoom> rooms = chatroomService.getAllChatRooms();
		if (rooms == null || rooms.size() == 0)
			return ResponseEntity.status(HttpStatus.OK).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(rooms);

	}

	// 방 생성
	@PostMapping("/room")
	public ResponseEntity<Long> createRoom(@RequestBody ChatRoom newRoom) {
		long resultOfCreation = chatroomService.createRoom(newRoom);
		if (resultOfCreation >= 0)
			return ResponseEntity.status(HttpStatus.OK).body(resultOfCreation);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Long.MIN_VALUE);
	}

	// 특정 채팅방 의 메세지 최근 10개
	@GetMapping("/room/message/{id}")
	public ResponseEntity<List<Message>> roomInfo(@PathVariable long mateNo,
			@RequestParam(value = "page", defaultValue = "0") String page) {
		long idx = page.equals("0") ? 0 : Integer.parseInt(page) * PAGE + 1;
		List<Message> msgList = messageService.getMessagesByChatroomId(mateNo, idx);
		return ResponseEntity.status(HttpStatus.OK).body(msgList);
	}

}