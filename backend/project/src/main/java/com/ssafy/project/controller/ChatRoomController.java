package com.ssafy.project.controller;

import java.util.List;

import com.ssafy.project.dto.ChatRoom;
import com.ssafy.project.dto.Message;
import com.ssafy.project.service.IChatRoomService;
import com.ssafy.project.service.IMessageService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://i6e102.p.ssafy.io", allowCredentials = "true", allowedHeaders = "*", methods = {
		RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.OPTIONS })
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
	public ResponseEntity<String> roomTitle(@PathVariable long id) {
		String roomTitle = chatroomService.getRoomTitle(id);
		if (roomTitle == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

		return ResponseEntity.status(HttpStatus.OK).body(roomTitle);
	}

	// 모든 채팅방 목록 반환
	@GetMapping("/rooms/{userNo}")
	public ResponseEntity<List<ChatRoom>> room(@PathVariable int userNo) {
		List<ChatRoom> rooms = chatroomService.getAllChatRooms(userNo);
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

	// 1:1 채팅방 생성
	@PostMapping("/room/{sendId}/{receiveId}")
	public ResponseEntity<Long> createRoom(@PathVariable int sendId, @PathVariable int receiveId) {
		long resultOfCreation;
		// 먼저 지금 대화를 신청할 사람과의 채팅방이 있는지 확인
		// 요기 만들어야한디~
		int check = chatroomService.checkReceiverRoom(sendId, receiveId);
		System.out.println("컨트롤러에서 체크한 값 : " + check);
		if (check == 0) { // 만약 sendId와의 개인 채팅방이 없다면....
			resultOfCreation = chatroomService.createPersonalRoom(sendId, receiveId);
		} else { // 방이 있다면..
			resultOfCreation = check;
		}

		if (resultOfCreation >= 0)
			return ResponseEntity.status(HttpStatus.OK).body(resultOfCreation);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Long.MIN_VALUE);
	}

	// 특정 채팅방 의 메세지 최근 10개
	@GetMapping("/room/message/{id}")
	public ResponseEntity<List<Message>> roomInfo(@PathVariable long id,
			@RequestParam(value = "page", defaultValue = "0") String page) {
		long idx = page.equals("0") ? 0 : Integer.parseInt(page) * PAGE + 1;
		List<Message> msgList = messageService.getMessagesByChatroomId(id, idx);
		return ResponseEntity.status(HttpStatus.OK).body(msgList);
	}

	// 개인채팅 삭제 (전체 삭제)
	@DeleteMapping("/room/delete/{id}")
	public ResponseEntity<Long> deletePersonalRoom(@PathVariable int id) {

		long resultOfCreation = chatroomService.deletePersonalRoom(id);

		if (resultOfCreation >= 0)
			return ResponseEntity.status(HttpStatus.OK).body(resultOfCreation);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Long.MIN_VALUE);
	}

	// 단체 채팅에서 나만 나가기
	@DeleteMapping("/room/delete/mymessage/{id}/{sendId}")
	public ResponseEntity<Long> deleteMyMessage(@PathVariable int id, @PathVariable int sendId) {

		long resultOfCreation = chatroomService.deleteMyMessage(id, sendId);

		if (resultOfCreation >= 0)
			return ResponseEntity.status(HttpStatus.OK).body(resultOfCreation);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Long.MIN_VALUE);
	}
}
