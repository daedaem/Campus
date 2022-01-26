package com.ssafy.project.service;

import com.ssafy.project.dao.LoginDao;
import com.ssafy.project.dto.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginDao loginDao;

    // login
    @Override
    public UserDto login(UserDto dto) {
        UserDto userDto = loginDao.confirm(dto.getUserEmail());
        if (userDto != null && userDto.getUserPassword().equals(dto.getUserPassword())) {
            userDto = loginDao.login(dto.getUserEmail());
            return userDto;
        } else {
            return null;
        }
    }

    // 카카오 로그인은 비밀번호를 입력 받지 않는다
    @Override
    public UserDto kakaoLogin(UserDto dto) {
        UserDto userDto = loginDao.login(dto.getUserEmail());
        return userDto;
    }

}
