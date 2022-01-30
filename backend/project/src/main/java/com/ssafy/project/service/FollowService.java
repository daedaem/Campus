package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.dto.UserDto;

public interface FollowService {
    // follow 추가
    public int followInsert(int userNo, int followUserNo);

    // follow 삭제
    public int followDelete(int userNo, int followUserNo);

    // follow 수
    public int followNum(int followUserNo);

    // follower 수
    public int followerNum(int userNo);

    // follow 리스트
    public List<UserDto> followList(int followUserNo);

    // follower 리스트
    public List<UserDto> followerList(int userNo);
}
