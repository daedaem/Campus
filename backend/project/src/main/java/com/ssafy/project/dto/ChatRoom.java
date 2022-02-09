package com.ssafy.project.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ChatRoom {
	private long id;
	private String title;
	private long masterId;

	@Builder
	public ChatRoom(long id, String title, long masterId) {
		super();
		this.id = id;
		this.title = title;
		this.masterId = masterId;
	}

}
