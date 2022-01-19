package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.dto.CampSiteDto;

public interface CampSiteService {
    // 캠핑장 전체 리스트
    public List<CampSiteDto> campSiteList();

    // 캠핑장 검색
    public List<CampSiteDto> campSiteSearch(String searchWord);

    // 도 선택
    public List<String> campSiteDo();

    // 시, 군, 구 선택
    public List<String> campSiteSigungu(String doNm);
}
