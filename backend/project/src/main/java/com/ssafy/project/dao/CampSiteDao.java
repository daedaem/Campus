package com.ssafy.project.dao;

import java.util.List;

import com.ssafy.project.dto.CampSiteDto;
import com.ssafy.project.dto.CampSiteParamDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CampSiteDao {
    // 캠핑장 전체 리스트
    public List<CampSiteDto> campSiteList(CampSiteParamDto campSiteParamDto);

    // 캠핑장 전체 리스트 개수
    public int campSiteListTotalCount();

    // 캠핑장 검색 리스트
    public List<CampSiteDto> campSiteSearch(CampSiteParamDto campSiteParamDto);

    // 캠핑장 검색 리스트 개수
    public int campSiteSearchTotalCount(CampSiteParamDto campSiteParamDto);

    // 캠핑장 정보
    public CampSiteDto campSiteDetail(String contentId);

    // 도 선택
    public List<String> campSiteDo();

    // 시, 군, 구 선택
    public List<String> campSiteSigungu(String doNm);
}
