package com.ssafy.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.project.dto.UserDto;
import com.ssafy.project.service.LoginService;

@CrossOrigin(origins = "http://localhost:5500", allowCredentials = "true", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.OPTIONS })
@RestController // 값자체를 리턴
public class LoginController {

    @Autowired
    LoginService loginService;

    // login 성공 -> session에 등록
    @PostMapping(value = "/login") // post 방식으로 들어옴
    public ResponseEntity<UserDto> login(@RequestBody UserDto dto, HttpSession session) {
        UserDto userDto = loginService.login(dto);
        System.out.println(userDto);
        if (userDto != null) {
            session.setAttribute("userDto", userDto);
            return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<UserDto>(userDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
