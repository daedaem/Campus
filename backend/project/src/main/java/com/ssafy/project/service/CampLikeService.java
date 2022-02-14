package com.ssafy.project.service;

import com.ssafy.project.dto.CampLikeParamDto;
import com.ssafy.project.dto.CampLikeResultDto;

public interface CampLikeService {
    // 캠핑장 좋아요 리스트
    public CampLikeResultDto campLikeList(int userNo);

    // 캠핑장 좋아요 추가
    public CampLikeResultDto campLikeInsert(CampLikeParamDto campLikeParamDto);

    // 캠핑장 좋아요 삭제
    public CampLikeResultDto campLikeDelete(CampLikeParamDto campLikeParamDto);
}
