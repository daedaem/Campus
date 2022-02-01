package com.ssafy.project.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.ssafy.project.dao.MateDao;
import com.ssafy.project.dao.SnsDao;
import com.ssafy.project.dto.MateCampEquipRequiredDto;
import com.ssafy.project.dto.MateCampStyleDto;
import com.ssafy.project.dto.MateDto;
import com.ssafy.project.dto.MateListDto;
import com.ssafy.project.dto.MateParamDto;
import com.ssafy.project.dto.MateResultDto;
import com.ssafy.project.dto.SnsImageDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MateServiceImpl implements MateService {

    @Autowired
    MateDao dao;

    @Autowired
    SnsDao snsdao;

    // @Autowired
    // MateCampEquipRequiredDto mateCampEquipRequiredDto;
    
    // @Autowired
    // MateCampStyleDto mateCampStyleDto;

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    private String uploadFile(File file, String fileName) throws IOException { // 파일 업로드
        BlobId blobId = BlobId.of("camp-us-9dace.appspot.com", fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        String jsonFile = "camp-us-9dace-firebase-adminsdk-68gfe-d8f1c14592.json";
        ClassPathResource cpr = new ClassPathResource(jsonFile);
        Credentials credentials = GoogleCredentials
                .fromStream(cpr.getInputStream());
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/camp-us-9dace.appspot.com/o/%s?alt=media";
        return String.format(DOWNLOAD_URL, URLEncoder.encode(fileName, "UTF-8"));
    }

    private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException { 
                                                                                                  
        File tempFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
            fos.close();
        }
        return tempFile;
    }

    private String getExtension(String fileName) { 
        return fileName.substring(fileName.lastIndexOf("."));
    }

    @Override
    public MateResultDto mateInsert(MateDto dto, MultipartFile multipartFile) {

    MateResultDto mateResultDto = new MateResultDto();

    try {
        //dto에 이미지 set
        System.out.println("!!");
        // String fileName = multipartFile.getOriginalFilename();
        // System.out.println(fileName);
        // fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));
        // File file = this.convertToFile(multipartFile, fileName);
        // String TEMP_URL = this.uploadFile(file, fileName);
        // dto.setMateImageUrl(TEMP_URL);
        System.out.println(dto.toString());
        dao.mateInsert(dto);
        
        dto.setMateNo(dao.mateNoselect());
        dao.mateCheck(dao.mateNoselect());

        dto.getCampStyleList().setMateNo(dto.getMateNo());
        dao.campStyleListInsert(dto.getCampStyleList());

        dto.getCampEquipRequiredList().setMateNo(dto.getMateNo());
        dao.campEquipReuireListInsert(dto.getCampEquipRequiredList());
        
        
        mateResultDto.setResult(SUCCESS);

    } catch (Exception e) {
    e.printStackTrace();
    mateResultDto.setResult(FAIL);
    }

    return mateResultDto;
    }

    @Override
    public MateResultDto mateDelete(int mateNo) {
        MateResultDto mateResultDto = new MateResultDto();

        try {

            dao.mateDelete(mateNo);
            mateResultDto.setResult(SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            mateResultDto.setResult(FAIL);
        }
        return mateResultDto;
    }

    @Override
    public MateResultDto mateList(MateParamDto mateParamDto) {

        MateResultDto mateResultDto = new MateResultDto();

        try {
            List<MateDto> list = dao.mateList(mateParamDto);
            int count = dao.mateListTotalCount();
            mateResultDto.setList(list);
            mateResultDto.setCount(count);
            mateResultDto.setResult(SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            mateResultDto.setResult(FAIL);
        }

        return mateResultDto;
    }

    @Override
    public MateResultDto mateDetail(int mateNo) {
        MateResultDto mateResultDto = new MateResultDto();

        try {
            dao.mateDetail(mateNo);

             MateDto mateDto = dao.mateDetail(mateNo);

            // 지원한사람 리스트
            List<MateListDto> mateApplyList = dao.mateApplyList(mateNo);
            mateDto.setMateList(mateApplyList);
            // 캠프스타일 리스트
            MateCampStyleDto campStyleList = dao.mateCampStyleList(mateNo);
            mateDto.setCampStyleList(campStyleList);
            // 장비 리스트
            MateCampEquipRequiredDto mateCampEquipRequired= dao.mateCampEquipRequiredList(mateNo);
            mateDto.setCampEquipRequiredList(mateCampEquipRequired);
            // 작성자 피드 리스트 이미지?
            List<SnsImageDto> snsImageList = dao.mateSnsImageList(mateDto.getUserNo());
            mateDto.setImageList(snsImageList);
            

            mateResultDto.setDto(mateDto);
            mateResultDto.setResult(SUCCESS);
            
        } catch (Exception e) {
            e.printStackTrace();
            mateResultDto.setResult(FAIL);
        }
        return mateResultDto;
    }

}
