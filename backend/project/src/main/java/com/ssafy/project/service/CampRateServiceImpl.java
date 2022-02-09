package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.dao.CampRateDao;
import com.ssafy.project.dto.CampRateDto;
import com.ssafy.project.dto.CampRateResultDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampRateServiceImpl implements CampRateService {

    @Autowired
    CampRateDao campRateDao;

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    @Override
    public CampRateResultDto campRateList(String contentId) {
        CampRateResultDto campRateResultDto = new CampRateResultDto();
        try {
            List<CampRateDto> list = campRateDao.campRateList(contentId);
            int count = campRateDao.campRateListTotalCount(contentId);
            campRateResultDto.setList(list);
            campRateResultDto.setCount(count);
            campRateResultDto.setResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            campRateResultDto.setResult(FAIL);
        }

        return campRateResultDto;
    }

    @Override
    public CampRateResultDto campRateDetail(int campRateNo) {
        CampRateResultDto campRateResultDto = new CampRateResultDto();
        try {
            CampRateDto campRateDto = campRateDao.campRateDetail(campRateNo);
            campRateResultDto.setDto(campRateDto);
            campRateResultDto.setResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            campRateResultDto.setResult(FAIL);
        }

        return campRateResultDto;
    }

    @Override
    public CampRateResultDto campRateInsert(CampRateDto campRateDto) {
        CampRateResultDto campRateResultDto = new CampRateResultDto();
        try {
            int result = campRateDao.campRateInsert(campRateDto);
            if (result == 1) {
                campRateResultDto.setResult(SUCCESS);
            } else {
                campRateResultDto.setResult(FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            campRateResultDto.setResult(FAIL);
        }

        return campRateResultDto;
    }

    @Override
    public CampRateResultDto campRateUpdate(CampRateDto campRateDto) {
        CampRateResultDto campRateResultDto = new CampRateResultDto();
        try {
            int result = campRateDao.campRateUpdate(campRateDto);
            System.out.println("campRateUpdate : " + result);
            if (result == 1) {
                campRateResultDto.setResult(SUCCESS);
            } else {
                campRateResultDto.setResult(FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            campRateResultDto.setResult(FAIL);
        }

        return campRateResultDto;
    }

    @Override
    public CampRateResultDto campRateDelete(int campRateNo) {
        CampRateResultDto campRateResultDto = new CampRateResultDto();
        try {
            int result = campRateDao.campRateDelete(campRateNo);
            if (result == 1) {
                campRateResultDto.setResult(SUCCESS);
            } else {
                campRateResultDto.setResult(FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            campRateResultDto.setResult(FAIL);
        }

        return campRateResultDto;
    }

}
