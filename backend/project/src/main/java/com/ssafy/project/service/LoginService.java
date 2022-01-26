package com.ssafy.project.service;

import com.ssafy.project.dto.UserDto;

public interface LoginService {
    public UserDto login(UserDto userDto);

    public UserDto kakaoLogin(UserDto userDto);
}
