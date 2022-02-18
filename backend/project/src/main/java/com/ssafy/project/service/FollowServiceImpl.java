package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.dao.FollowDao;
import com.ssafy.project.dto.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    FollowDao followDao;

    // follow 추가
    @Override
    public int followInsert(int userNo, int followUserNo) {
        return followDao.followInsert(userNo, followUserNo);
    }

    // follow 삭제
    @Override
    public int followDelete(int userNo, int followUserNo) {
        return followDao.followDelete(userNo, followUserNo);
    }

    // follow 수 구하기
    @Override
    public int followNum(int followUserNo) {
        return followDao.followNum(followUserNo);
    }

    // follower 수 구하기
    @Override
    public int followerNum(int userNo) {
        return followDao.followerNum(userNo);
    }

    // follow list
    @Override
    public List<UserDto> followList(int followUserNo) {
        return followDao.followList(followUserNo);
    }

    // follower list
    @Override
    public List<UserDto> followerList(int userNo) {
        return followDao.followerList(userNo);
    }

}
