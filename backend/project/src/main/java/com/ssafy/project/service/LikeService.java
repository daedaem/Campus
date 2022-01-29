package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.dto.SnsDto;

public interface LikeService {
    public int likeInsert( int snsNo,int userNo);
    public int likeDelete(int snsNo, int userNo);

    public List<SnsDto> likeList(int userNo);

    public int likeCount(int snsNo);
}
