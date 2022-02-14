package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.dao.CampLikeDao;
import com.ssafy.project.dto.CampLikeParamDto;
import com.ssafy.project.dto.CampLikeResultDto;
import com.ssafy.project.dto.CampSiteDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampLikeServiceImpl implements CampLikeService {

    @Autowired
    CampLikeDao campLikeDao;

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    @Override
    public CampLikeResultDto campLikeList(int userNo) {
        CampLikeResultDto campLikeResultDto = new CampLikeResultDto();
        try {
            List<CampSiteDto> list = campLikeDao.campLikeList(userNo);
            campLikeResultDto.setCampLikeList(list);
            campLikeResultDto.setResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            campLikeResultDto.setResult(FAIL);
        }

        return campLikeResultDto;
    }

    @Override
    public CampLikeResultDto campLikeInsert(CampLikeParamDto campLikeParamDto) {
        CampLikeResultDto campLikeResultDto = new CampLikeResultDto();
        try {
            int result = campLikeDao.campLikeInsert(campLikeParamDto);
            if (result == 1) {
                campLikeResultDto.setResult(SUCCESS);
            } else {
                campLikeResultDto.setResult(FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            campLikeResultDto.setResult(FAIL);
        }

        return campLikeResultDto;
    }

    @Override
    public CampLikeResultDto campLikeDelete(CampLikeParamDto campLikeParamDto) {
        CampLikeResultDto campLikeResultDto = new CampLikeResultDto();
        try {
            int result = campLikeDao.campLikeDelete(campLikeParamDto);
            if (result == 1) {
                campLikeResultDto.setResult(SUCCESS);
            } else {
                campLikeResultDto.setResult(FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            campLikeResultDto.setResult(FAIL);
        }

        return campLikeResultDto;
    }

}
