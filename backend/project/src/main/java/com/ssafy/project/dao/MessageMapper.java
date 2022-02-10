package com.ssafy.project.dao;

import java.util.List;

import com.ssafy.project.dto.Message;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MessageMapper {

	int insertMessage(Message chatMessage);
	List<Message> getMessagesByChatroomId(@Param("id") long id, @Param("idx") long idx);


}
