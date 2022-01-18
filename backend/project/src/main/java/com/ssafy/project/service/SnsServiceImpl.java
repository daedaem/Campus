package com.ssafy.project.service;

import java.io.IOException;

import com.ssafy.project.dao.SnsDao;
import com.ssafy.project.dto.SnsDto;
import com.ssafy.project.dto.SnsParamDto;
import com.ssafy.project.dto.SnsResultDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class SnsServiceImpl implements SnsService{

    @Autowired
    SnsDao dao;

    String uploadFolder;

    String uploadPath;

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    
    @Override
    @Transactional
    public SnsResultDto snsInsert(SnsDto dto, MultipartHttpServletRequest request) {
        
        SnsResultDto snsResultDto = new SnsResultDto();

        try{

        }catch(IOException e){
            e.printStackTrace();
            snsResultDto.setResult(FAIL);
        }

        return null;
    }

    @Override
    public SnsResultDto snsList(SnsParamDto snsParamDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SnsResultDto snsUpdate(SnsDto dto, MultipartHttpServletRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SnsResultDto Delete(int snsNo) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
