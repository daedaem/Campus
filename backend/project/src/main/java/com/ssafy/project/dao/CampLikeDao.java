package com.ssafy.project.dao;

import java.util.List;

import com.ssafy.project.dto.CampLikeParamDto;
import com.ssafy.project.dto.CampSiteDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CampLikeDao {
    // 캠핑장 좋아요 리스트
    public List<CampSiteDto> campLikeList(int userNo);

    // 캠핑장 좋아요 추가
    public int campLikeInsert(CampLikeParamDto campLikeParamDto);

    // 캠핑장 좋아요 삭제
    public int campLikeDelete(CampLikeParamDto campLikeParamDto);
}
