package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.dao.LikeDao;
import com.ssafy.project.dto.SnsDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService{

    @Autowired
    LikeDao dao;

    @Override
    public int likeInsert(int snsNo, int userNo) {
        return dao.likeInsert(snsNo, userNo);
    }

    @Override
    public int likeDelete(int snsNo, int userNo) {
        return dao.likeDelete(snsNo, userNo);
    }

    @Override
    public List<SnsDto> likeList(int userNo) {
        return dao.likeList(userNo);
    }

    @Override
    public int likeCount(int snsNo) {
        return dao.likeCount(snsNo);
    }
    
}
