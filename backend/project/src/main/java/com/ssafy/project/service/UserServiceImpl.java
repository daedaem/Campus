package com.ssafy.project.service;

import com.ssafy.project.dao.UserDao;
import com.ssafy.project.dto.UserDto;
import com.ssafy.project.dto.UserResultDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDto userSelect(int userNo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserResultDto userRegister(UserDto userDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserResultDto userUpdate(UserDto userDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserResultDto userDelete(int userNo) {
        // TODO Auto-generated method stub
        return null;
    }

}
