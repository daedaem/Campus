package com.ssafy.project.dao;

import java.util.List;

import com.ssafy.project.dto.UserDto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FollowDao {
    // follow 추가
    public int followInsert(@Param("userNo") int userNo, @Param("followUserNo") int followUserNo);

    // follow 삭제
    public int followDelete(@Param("userNo") int userNo, @Param("followUserNo") int followUserNo);

    // follow 수 구하기
    public int followNum(int followUserNo);

    // follower 수 구하기
    public int followerNum(int userNo);

    // follow list
    public List<UserDto> followList(int followUserNo);

    // follower list
    public List<UserDto> followerList(int userNo);
}
