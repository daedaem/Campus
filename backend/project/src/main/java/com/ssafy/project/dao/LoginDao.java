package com.ssafy.project.dao;

import com.ssafy.project.dto.UserDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
    // 비밀번호가 일치하는지 확인
    public UserDto confirm(String userEmail);

    // 일치하면 로그인
    public UserDto login(String userEmail);
}