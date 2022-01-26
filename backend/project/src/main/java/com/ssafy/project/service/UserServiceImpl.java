package com.ssafy.project.service;

import com.ssafy.project.dao.UserDao;
import com.ssafy.project.dto.UserDto;
import com.ssafy.project.dto.UserRateDto;
import com.ssafy.project.dto.UserResultDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    // userEmail에 해당하는 user정보 return
    @Override
    public UserDto userSelect(String userEmail) {
        UserDto dto = null;
        dto = userDao.userSelect(userEmail);

        return dto;
    }

    // 회원가입
    @Override
    public UserResultDto userRegister(UserDto userDto) {
        UserResultDto userResultDto = new UserResultDto();
        if (userDao.userInsert(userDto) == SUCCESS) { // 가입 성공
            userResultDto.setResult(SUCCESS);
        } else { // 가입 실패
            userResultDto.setResult(FAIL);
        }
        return userResultDto;
    }

    // user정보 업데이트
    @Override
    public UserResultDto userUpdate(UserDto userDto) {
        UserResultDto userResultDto = new UserResultDto();
        if (userDao.userUpdate(userDto) == SUCCESS) { // 수정 성공
            userResultDto.setResult(SUCCESS);
        } else { // 수정 실패
            userResultDto.setResult(FAIL);
        }
        return userResultDto;
    }

    // 가입 시 user 세부 정보 입력
    @Override
    public UserResultDto userUpdateCamp(UserDto userDto) {
        UserResultDto userResultDto = new UserResultDto();
        if (userDao.userUpdateCamp(userDto) == SUCCESS) { // 수정 성공
            userResultDto.setResult(SUCCESS);
        } else { // 수정 실패
            userResultDto.setResult(FAIL);
        }
        return userResultDto;
    }

    // 가입 시 mbti
    @Override
    public UserResultDto userUpdateMBTI(String userMBTI) {
        UserResultDto userResultDto = new UserResultDto();
        if (userDao.userUpdateMBTI(userMBTI) == SUCCESS) { // 수정 성공
            userResultDto.setResult(SUCCESS);
        } else { // 수정 실패
            userResultDto.setResult(FAIL);
        }
        return userResultDto;
    }

    // 가입 시 이미지 등록
    // @Override
    // public UserResultDto userUpdateProfileImage() {
    // UserResultDto userResultDto = new UserResultDto();
    // if (userDao.userUpdateProfileImage(userMBTI) == SUCCESS) { // 수정 성공
    // userResultDto.setResult(SUCCESS);
    // } else { // 수정 실패
    // userResultDto.setResult(FAIL);
    // }
    // return userResultDto;
    // }

    // userEmail에 해당하는 유저 정보 삭제
    @Override
    public UserResultDto userDelete(String userEmail) {
        UserResultDto userResultDto = new UserResultDto();
        if (userDao.userDelete(userEmail) != FAIL) { // 탈퇴 성공
            userResultDto.setResult(SUCCESS);
        } else { // 탈퇴 실패
            userResultDto.setResult(FAIL);
        }
        return userResultDto;
    }

    @Override
    public UserResultDto userRate(UserRateDto userRateDto) {
        UserResultDto userResultDto = new UserResultDto();
        if (userDao.userRate(userRateDto) == SUCCESS) {
            userResultDto.setResult(SUCCESS);
        } else {
            userResultDto.setResult(FAIL);
        }
        return userResultDto;
    }

    @Override
    public UserResultDto userDuplEmail(String userEmail) {
        UserResultDto userResultDto = new UserResultDto();
        if (userDao.userDuplEmail(userEmail) == 0) { // 중복되는 이메일이 없음
            userResultDto.setResult(SUCCESS);
        } else {
            userResultDto.setResult(FAIL);
        }
        return userResultDto;
    }

    @Override
    public UserResultDto userDuplNickname(String userNickname) {
        UserResultDto userResultDto = new UserResultDto();
        if (userDao.userDuplNickname(userNickname) == 0) { // 중복되는 닉네임이 없음
            userResultDto.setResult(SUCCESS);
        } else {
            userResultDto.setResult(FAIL);
        }
        return userResultDto;
    }

}
