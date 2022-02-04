package com.ssafy.project.service;

import com.ssafy.project.dto.UserDto;

public interface LoginService {
    // 로그인
    public UserDto login(UserDto userDto);

    // 카카오 로그인
    public UserDto kakaoLogin(UserDto userDto);
}
