package com.ssafy.project.dao;

import com.ssafy.project.dto.UserDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public int userRegister(UserDto userDto);

    public UserDto userSelect(String userEmail);

    public int userUpdate(UserDto userDto);

    public int userDelete(String userEmail);
}
