package com.ssafy.project.dao;

import java.util.List;

import com.ssafy.project.dto.SnsDto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikeDao {
    public int likeInsert(
        @Param("snsNo") int snsNo,
        @Param("userNo") int userNo
    );
    public int likeDelete(int snsNo, int userNo);

    public List<SnsDto> likeList(int snsNo);

    public int likeCount(int snsNo);
}
