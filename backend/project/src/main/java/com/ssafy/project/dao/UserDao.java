package com.ssafy.project.dao;

import com.ssafy.project.dto.UserDto;
import com.ssafy.project.dto.UserRateDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    // 회원 가입
    public int userInsert(UserDto userDto);

    // userEmail에 해당하는 user 정보
    public UserDto userSelect(String userEmail);

    // user정보 업데이트
    public int userUpdate(UserDto userDto);

    // 가입 시 user 세부 정보 입력
    public int userUpdateCamp(UserDto userDto);

    // 가입 시 mbti
    public int userUpdateMBTI(UserDto userDto);

    // 유저 이미지 등록
    public int userUpdateProfileImage(UserDto userDto);

    // userEmail에 해당하는 user 삭제
    public int userDelete(String userEmail);

    // user 평점
    public int userRate(UserRateDto userRateDto);

    // email 중복 확인
    public int userDuplEmail(String userEmail);

    // 닉네임 중복 확인
    public int userDuplNickname(String userNickname);
}
