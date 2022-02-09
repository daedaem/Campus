package com.ssafy.project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class ChatRoomP {
	private long id;
	private String title;
	private long masterId;

	@Builder
	public ChatRoomP(long id, String title, long masterId) {
		super();
		this.id = id;
		this.title = title;
		this.masterId = masterId;
	}

}
