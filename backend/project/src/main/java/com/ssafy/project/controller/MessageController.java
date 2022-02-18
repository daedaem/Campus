package com.ssafy.project.controller;

import com.ssafy.project.dto.Message;
import com.ssafy.project.service.IMessageService;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "https://i6e102.p.ssafy.io", allowCredentials = "true", allowedHeaders = "*", methods = {
		RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.OPTIONS })
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
