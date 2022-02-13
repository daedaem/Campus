package com.ssafy.project.controller;

import com.ssafy.project.dto.Message;
import com.ssafy.project.service.IMessageService;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMethod;
=======
>>>>>>> ad19d36f3c52c65186f7e92661d1337af76ffe98
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

<<<<<<< HEAD
@CrossOrigin(origins = "http://localhost:5500", allowCredentials = "true", allowedHeaders = "*", methods = {
	RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
	RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.OPTIONS })
=======
@CrossOrigin(origins = "http://localhost:5500")
>>>>>>> ad19d36f3c52c65186f7e92661d1337af76ffe98
@Slf4j
@RequiredArgsConstructor
@RestController
public class MessageController {
	private final IMessageService messageService;
	private final SimpMessagingTemplate template;

	@MessageMapping("/message")
	public void sendMessage(@Payload Message chatMessage) {
		log.info("전달 메세지 : " + chatMessage);
		
		messageService.insertMessage(chatMessage);
		template.convertAndSend("/sub/" + chatMessage.getChatroomId(), chatMessage);
	}
}
