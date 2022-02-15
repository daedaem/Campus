package com.ssafy.project.service;

import com.ssafy.project.dto.UserDto;
import com.ssafy.project.dto.UserRateDto;
import com.ssafy.project.dto.UserResultDto;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    // 유저 상세 정보
    public UserDto userSelect(String userEmail);

    // 회원 가입
    public UserResultDto userRegister(UserDto userDto);

    // 회원 정보 수정
    public UserResultDto userUpdate(UserDto userDto);

    // 캠핑 스타일 정보 수정
    public UserResultDto userUpdateCamp(UserDto userDto);

    // 회원 정보 중 MBTI 수정
    public UserResultDto userUpdateMBTI(UserDto userDto);

    // public String userUpdateProfileImage(MultipartFile multipartFile);
    public UserResultDto userUpdateProfileImageKakao(UserDto userDto);

    // 회원 정보 중 프로필 이미지 수정
    public UserResultDto userUpdateProfileImage(String userEmail, MultipartFile multipartFile);

    // 회원 탈퇴
    public UserResultDto userDelete(String userEmail);

    // 회원 평점
    public UserResultDto userRate(UserRateDto userRateDto);

    // 이메일 중복 검사
    public UserResultDto userDuplEmail(String userEmail);

    // 닉네임 중복 검사
    public UserResultDto userDuplNickname(String userNickname);
}
