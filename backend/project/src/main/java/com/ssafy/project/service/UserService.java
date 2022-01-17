package com.ssafy.project.service;

import com.ssafy.project.dto.UserDto;
import com.ssafy.project.dto.UserResultDto;

public interface UserService {
    public UserDto userSelect(int userNo);

    public UserResultDto userRegister(UserDto userDto);

    public UserResultDto userUpdate(UserDto userDto);

    public UserResultDto userDelete(int userNo);
}
