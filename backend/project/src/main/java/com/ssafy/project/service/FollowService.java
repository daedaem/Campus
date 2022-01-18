package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.dto.UserDto;

public interface FollowService {
    public int followInsert(int userNo, int followUserNo);

    public int followDelete(int userNo, int followUserNo);

    public int followNum(int followUserNo);

    public int followerNum(int userNo);

    public List<UserDto> followList(int followUserNo);

    public List<UserDto> followerList(int userNo);
}
