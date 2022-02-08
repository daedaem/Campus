package com.ssafy.project.service;

import com.ssafy.project.dao.UserMapper;
import com.ssafy.project.dto.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UUserService implements IUserService{
    
    @Autowired
    UserMapper userMapper;

	@Override
	public long createUser(User newUser) {
		int result = userMapper.createUser(newUser);
		return result == 0 ? -1 : newUser.getId();
	}

	@Override
	public boolean signin(User user) {
		// TODO Auto-generated method stub
		return userMapper.signin(user) == 0 ? false : true;
	}
}
