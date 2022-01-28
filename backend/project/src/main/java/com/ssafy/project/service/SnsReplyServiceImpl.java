package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.dao.SnsReplyDao;
import com.ssafy.project.dto.SnsReplyDto;
import com.ssafy.project.dto.SnsReplyResultDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnsReplyServiceImpl implements SnsReplyService {

    @Autowired
    SnsReplyDao dao;

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    @Override
    public SnsReplyResultDto snsReplyList(int snsReplyNo) {
        
        SnsReplyResultDto snsReplyResultDto = new SnsReplyResultDto();

        try {
            
            List<SnsReplyDto> list = dao.snsReplyList(snsReplyNo);
            int count = dao.snsReplyCount(snsReplyNo);
            snsReplyResultDto.setList(list);
            snsReplyResultDto.setCount(count);
            snsReplyResultDto.setResult(SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            snsReplyResultDto.setResult(FAIL);
        }

        return snsReplyResultDto;
    }

    @Override
    public SnsReplyResultDto SnsReplyInsert(SnsReplyDto dto) {

        SnsReplyResultDto snsReplyResultDto = new SnsReplyResultDto();
        
        try {

            dao.snsReplyInsert(dto);
            snsReplyResultDto.setResult(SUCCESS);
            
        } catch (Exception e) {
            e.printStackTrace();
            snsReplyResultDto.setResult(FAIL);
        }

        return snsReplyResultDto;
    }

    @Override
    public SnsReplyResultDto SnsReplyDelete(int snsReplyNo) {

        SnsReplyResultDto snsReplyResultDto = new SnsReplyResultDto();

        try {

            dao.snsReplyDelete(snsReplyNo);
            snsReplyResultDto.setResult(SUCCESS);
            
        } catch (Exception e) {
            e.printStackTrace();
            snsReplyResultDto.setResult(FAIL);
        }
        return snsReplyResultDto;
    }

    @Override
    public SnsReplyResultDto SnsReplyUpdate(SnsReplyDto dto) {

        SnsReplyResultDto snsReplyResultDto = new SnsReplyResultDto();

        try {

            dao.snsReplyUpdate(dto);
            snsReplyResultDto.setResult(SUCCESS);
            
        } catch (Exception e) {
            e.printStackTrace();
            snsReplyResultDto.setResult(FAIL);
        }
        return snsReplyResultDto;
    }
    
}
