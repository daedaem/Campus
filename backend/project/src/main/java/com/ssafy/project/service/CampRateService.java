package com.ssafy.project.service;

import com.ssafy.project.dto.CampRateDto;
import com.ssafy.project.dto.CampRateResultDto;

public interface CampRateService {
    // 캠핑장 평점 리스트
    public CampRateResultDto campRateList(String contentId);

    // 캠핑장 평점 상세 정보
    public CampRateResultDto campRateDetail(int campRateNo);

    // 캠핑장 평점 추가
    public CampRateResultDto campRateInsert(CampRateDto campRateDto);

    // 캠핑장 평점 수정
    public CampRateResultDto campRateUpdate(CampRateDto campRateDto);

    // 캠핑장 평점 삭제
    public CampRateResultDto campRateDelete(int campRateNo);
}
