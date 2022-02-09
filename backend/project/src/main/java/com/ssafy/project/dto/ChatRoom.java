package com.ssafy.project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class ChatRoom {
	private long mateNo;
	private String title;
	private long masterId;

	@Builder
	public ChatRoom(long mateNo, String title, long masterId) {
		super();
		this.mateNo = mateNo;
		this.title = title;
		this.masterId = masterId;
	}

}
