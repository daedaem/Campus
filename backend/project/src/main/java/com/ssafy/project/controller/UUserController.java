package com.ssafy.project.controller;

import com.ssafy.project.dto.User;
import com.ssafy.project.service.IUserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@RestController
public class UUserController {
    private final IUserService userService;

	// 유저 생성
	@PostMapping("/uuser")
	public ResponseEntity<User> createUser(@RequestBody User newUser) {
		System.out.println(newUser);
		long resultOfCreation = userService.createUser(newUser);
		if (resultOfCreation >= 0)
			return ResponseEntity.status(HttpStatus.OK).body(newUser);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}

	// 정보 확인
	@PostMapping("/llogin")
	public ResponseEntity<String> signinUser(@RequestBody User user) {
		boolean resultOfSignin = userService.signin(user);
		if (resultOfSignin)
			return ResponseEntity.status(HttpStatus.OK).body(user.getNickname());
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
}
