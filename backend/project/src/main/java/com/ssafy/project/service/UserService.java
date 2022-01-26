package com.ssafy.project.service;

import com.ssafy.project.dto.UserDto;
import com.ssafy.project.dto.UserRateDto;
import com.ssafy.project.dto.UserResultDto;

public interface UserService {
    public UserDto userSelect(String userEmail);

    public UserResultDto userRegister(UserDto userDto);

    public UserResultDto userUpdate(UserDto userDto);

    public UserResultDto userUpdateCamp(UserDto userDto);

    public UserResultDto userUpdateMBTI(String userMBTI);

    // 가입 시 이미지 등록
    // public UserResultDto userUpdateProfileImage();

    public UserResultDto userDelete(String userEmail);

    public UserResultDto userRate(UserRateDto userRateDto);

    public UserResultDto userDuplEmail(String userEmail);

    public UserResultDto userDuplNickname(String userNickname);
}
