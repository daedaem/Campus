package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.dao.CampRateReplyDao;
import com.ssafy.project.dto.CampRateReplyDto;
import com.ssafy.project.dto.CampRateReplyResultDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampRateReplyServiceImpl implements CampRateReplyService {

    @Autowired
    CampRateReplyDao campRateReplyDao;

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    @Override
    public CampRateReplyResultDto campRateReplyList(int campRateNo) {
        CampRateReplyResultDto campRateReplyResultDto = new CampRateReplyResultDto();
        try {
            List<CampRateReplyDto> list = campRateReplyDao.campRateReplyList(campRateNo);
            int count = campRateReplyDao.campRateReplyListTotalCount(campRateNo);
            campRateReplyResultDto.setList(list);
            campRateReplyResultDto.setCount(count);
            campRateReplyResultDto.setResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            campRateReplyResultDto.setResult(FAIL);
        }

        return campRateReplyResultDto;
    }

    @Override
    public CampRateReplyResultDto campRateReplyInsert(CampRateReplyDto campRateReplyDto) {
        CampRateReplyResultDto campRateReplyResultDto = new CampRateReplyResultDto();
        try {
            campRateReplyDao.campRateReplyInsert(campRateReplyDto);
            campRateReplyResultDto.setResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            campRateReplyResultDto.setResult(FAIL);
        }

        return campRateReplyResultDto;
    }

    @Override
    public CampRateReplyResultDto campRateReplyUpdate(CampRateReplyDto campRateReplyDto) {
        CampRateReplyResultDto campRateReplyResultDto = new CampRateReplyResultDto();
        try {
            campRateReplyDao.campRateReplyUpdate(campRateReplyDto);
            campRateReplyResultDto.setResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            campRateReplyResultDto.setResult(FAIL);
        }

        return campRateReplyResultDto;
    }

    @Override
    public CampRateReplyResultDto campRateReplyDelete(int campRateReplyNo) {
        CampRateReplyResultDto campRateReplyResultDto = new CampRateReplyResultDto();
        try {
            campRateReplyDao.campRateReplyDelete(campRateReplyNo);
            campRateReplyResultDto.setResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            campRateReplyResultDto.setResult(FAIL);
        }

        return campRateReplyResultDto;
    }
}
