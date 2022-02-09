package com.ssafy.project.dao;

import com.ssafy.project.dto.User;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	int createUser(User newUser);
	int signin(User user);
}
