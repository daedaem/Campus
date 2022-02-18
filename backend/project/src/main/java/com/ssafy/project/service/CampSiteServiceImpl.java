package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.dao.CampSiteDao;
import com.ssafy.project.dto.CampSiteDto;
import com.ssafy.project.dto.CampSiteParamDto;
import com.ssafy.project.dto.CampSiteResultDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampSiteServiceImpl implements CampSiteService {

    @Autowired
    private CampSiteDao campSiteDao;

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    @Override
    public CampSiteResultDto campSiteList(CampSiteParamDto campSiteParamDto) {
        CampSiteResultDto campSiteResultDto = new CampSiteResultDto();

        try {
            List<CampSiteDto> list = campSiteDao.campSiteList(campSiteParamDto);
            int count = campSiteDao.campSiteListTotalCount();
            campSiteResultDto.setList(list);
            campSiteResultDto.setCount(count);
            campSiteResultDto.setResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            campSiteResultDto.setResult(FAIL);
        }

        return campSiteResultDto;
    }

    @Override
    public CampSiteResultDto campSiteSearch(CampSiteParamDto campSiteParamDto) {
        CampSiteResultDto campSiteResultDto = new CampSiteResultDto();

        try {
            List<CampSiteDto> list = campSiteDao.campSiteSearch(campSiteParamDto);
            int count = campSiteDao.campSiteSearchTotalCount(campSiteParamDto);
            campSiteResultDto.setList(list);
            campSiteResultDto.setCount(count);
            campSiteResultDto.setResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            campSiteResultDto.setResult(FAIL);
        }

        return campSiteResultDto;
    }

    @Override
    public CampSiteResultDto campSiteSearchNull(CampSiteParamDto campSiteParamDto) {
        CampSiteResultDto campSiteResultDto = new CampSiteResultDto();

        try {
            List<CampSiteDto> list = campSiteDao.campSiteSearchNull(campSiteParamDto);
            int count = campSiteDao.campSiteSearchNullTotalCount(campSiteParamDto);
            campSiteResultDto.setList(list);
            campSiteResultDto.setCount(count);
            campSiteResultDto.setResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            campSiteResultDto.setResult(FAIL);
        }

        return campSiteResultDto;
    }

    @Override
    public CampSiteResultDto campSiteDetail(String contentId) {
        CampSiteResultDto campSiteResultDto = new CampSiteResultDto();

        try {
            CampSiteDto campSiteDto = campSiteDao.campSiteDetail(contentId);
            campSiteResultDto.setDto(campSiteDto);
            campSiteResultDto.setResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            campSiteResultDto.setResult(FAIL);
        }

        return campSiteResultDto;
    }

    @Override
    public List<String> campSiteDo() {
        return campSiteDao.campSiteDo();
    }

    @Override
    public List<String> campSiteSigungu(String doNm) {
        return campSiteDao.campSiteSigungu(doNm);
    }

}
