package com.ssafy.project.service;

import com.ssafy.project.dto.UserDto;
import com.ssafy.project.dto.UserRateDto;
import com.ssafy.project.dto.UserResultDto;

public interface UserService {
    public UserDto userSelect(String userEmail);

    public UserResultDto userRegister(UserDto userDto);

    public UserResultDto userUpdate(UserDto userDto);

    public UserResultDto userDelete(String userEmail);

    public UserResultDto userRate(UserRateDto userRateDto);
}
