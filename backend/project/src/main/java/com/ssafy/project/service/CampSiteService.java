package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.dto.CampSiteParamDto;
import com.ssafy.project.dto.CampSiteResultDto;

public interface CampSiteService {
    // 캠핑장 전체 리스트
    public CampSiteResultDto campSiteList(CampSiteParamDto campSiteParamDto);

    // 캠핑장 검색
    public CampSiteResultDto campSiteSearch(CampSiteParamDto campSiteParamDto);

    // 캠핑장 정보
    public CampSiteResultDto campSiteDetail(String contentId);

    // 도 선택
    public List<String> campSiteDo();

    // 시, 군, 구 선택
    public List<String> campSiteSigungu(String doNm);
}
