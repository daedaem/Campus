package com.ssafy.project.service;

import java.util.List;

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
            dao.snsInsert(dto); //dto는 키값


            /*
            List<MultipartFile> imageList = request.getFiles("file");

            File uploadDir = new File(uploadPath + File.separator + uploadFolder); // 지정된 경로 사용
            if (!uploadDir.exists()) uploadDir.mkdir(); // 지정된 경로가 없을시에 자동으로 경로 생성

            for (MultipartFile multipartFile : imageList) {
                
                int snsNo = dto.getSnsNo();

                String imageName = part.getOriginalFilename();
            }*/
            

            snsResultDto.setResult(SUCCESS);
            

        }catch(Exception e){
            e.printStackTrace();
            snsResultDto.setResult(FAIL);
        }

        return snsResultDto;
    }

    // 리스트를 생성하고 sns와 user를 join한 값들을 list에 순차적으로 저장(count는 sns에 있는 튜플의 개수로 지정)
    @Override
    public SnsResultDto snsList(SnsParamDto snsParamDto) {
        
        SnsResultDto snsResultDto = new SnsResultDto();

        try{
            List<SnsDto> list = dao.snsList(snsParamDto);
            int count = dao.snsListTotalCount();
            snsResultDto.setList(list);
            snsResultDto.setCount(count);
            snsResultDto.setResult(SUCCESS);
        
        }catch(Exception e){
            e.printStackTrace();
            snsResultDto.setResult(FAIL);
        }

        return snsResultDto;
    }

    @Override
    public SnsResultDto snsListSearchWord(SnsParamDto snsParamDto) {
        
        SnsResultDto snsResultDto = new SnsResultDto();

        try{
            List<SnsDto> list = dao.snsListSearchWord(snsParamDto);
            int count = dao.snsListSearchWordTotalCount();
            snsResultDto.setList(list);
            snsResultDto.setCount(count);
            snsResultDto.setResult(SUCCESS);
        
        }catch(Exception e){
            e.printStackTrace();
            snsResultDto.setResult(FAIL);
        }

        return snsResultDto;
    }

    @Override
    @Transactional
    public SnsResultDto snsUpdate(SnsDto dto, MultipartHttpServletRequest request) {
        
        SnsResultDto snsResultDto = new SnsResultDto();

        try {
            dao.snsUpdate(dto);

            // 만약 로컬에 이미지를 저장하게되면
            // 로컬에 있는 이미지를 삭제, db에 저장된 이미지 url삭제 
            // 이후 insert하는 방식

            snsResultDto.setResult(SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            snsResultDto.setResult(FAIL);
        }


        return snsResultDto;
    }

    @Override
    @Transactional
    public SnsResultDto snsDelete(int snsNo) {
        
        SnsResultDto snsResultDto = new SnsResultDto();

        try {
            //로컬에 저장된 이미지 삭제

            //snsImageDelete(snsNo);
            //댓글 삭제;
            dao.snsDelete(snsNo); // 마지막으로 글 삭제

            snsResultDto.setResult(SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            snsResultDto.setResult(FAIL);
        }

        return snsResultDto;
    }

    
}
