package com.ssafy.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Message {
	private long id;
	private String title;
	private String content;
	private long chatroomId;
	private long senderId;
	private String senderNickname;

	@Builder
	public Message(long id, String title, String content, long chatroomId, long senderId) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.chatroomId = chatroomId;
		this.senderId = senderId;
	}

}
