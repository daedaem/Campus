package com.ssafy.project.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import com.ssafy.project.dao.SnsDao;
import com.ssafy.project.dto.SnsDto;
import com.ssafy.project.dto.SnsImageDto;
import com.ssafy.project.dto.SnsParamDto;
import com.ssafy.project.dto.SnsResultDto;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class SnsServiceImpl implements SnsService{
    
    @Autowired
    SnsDao dao;
    
    @Value("${app.fileupload.uploadDir}")
    String uploadFolder;
    
    @Value("${app.fileupload.uploadPath}")
    String uploadPath;

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    
    @Override
    @Transactional
    public SnsResultDto snsInsert(SnsDto dto, MultipartHttpServletRequest request) {
        
        SnsResultDto snsResultDto = new SnsResultDto();

        try{
            dao.snsInsert(dto); //dto는 키값


            List<MultipartFile> fileList = request.getFiles("file"); // file를 MultiparFile로 넘겨줌으로 각각의 파일이 filelist에 저장된다.

            File uploadDir = new File(uploadPath + File.separator + uploadFolder); // 경로지정
            if (!uploadDir.exists()) uploadDir.mkdir(); // 만약 경로가 없다면 자동으로 만들어 준다.

            for (MultipartFile part : fileList) {

                int snsNo = dto.getSnsNo(); // DB에서 auto incremernt된 값들이 넘어온다.
                
                String fileName = part.getOriginalFilename(); // 실제로 첨부했을때 file 이름
                
                //Random File Id
                UUID uuid = UUID.randomUUID(); // id가 중복되지 않도록 해준다.
                
                //file extension
                String extension = FilenameUtils.getExtension(fileName); // vs FilenameUtils.getBaseName() // 확장자
            
                String savingFileName = uuid + "." + extension; // 파일 이름과 확장자를 붙인다.
            
                File destFile = new File(uploadPath + File.separator + uploadFolder + File.separator + savingFileName); // 최종 경로
                
                System.out.println(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
                part.transferTo(destFile); // part를 destFile쪽으로 넘긴다.	
            
                // Table Insert
                SnsImageDto snsImageDto = new SnsImageDto();
                snsImageDto.setSnsNo(snsNo);
                snsImageDto.setSnsImageName(fileName);
                snsImageDto.setSnsImageSize(part.getSize());
                snsImageDto.setSnsImageContentType(part.getContentType());
                String snsImageUrl = uploadFolder + "/" + savingFileName;
                snsImageDto.setSnsImageUrl(snsImageUrl);
                
                dao.snsImageInsert(snsImageDto);
            }
            

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
        System.out.println("1");

        try{
            System.out.println("2");
            List<SnsDto> list = dao.snsList(snsParamDto);
            //List<>
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
            System.out.println("delete serviceImpl");
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
