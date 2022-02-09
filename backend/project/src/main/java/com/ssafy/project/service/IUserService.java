package com.ssafy.project.service;

import com.ssafy.project.dto.User;

public interface IUserService {

	long createUser(User newUser);
	boolean signin(User user);

}
