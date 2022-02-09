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
import com.ssafy.project.dao.SnsDao;
import com.ssafy.project.dto.SnsDto;
import com.ssafy.project.dto.SnsImageDto;
import com.ssafy.project.dto.SnsParamDto;
import com.ssafy.project.dto.SnsReplyDto;
import com.ssafy.project.dto.SnsResultDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SnsServiceImpl implements SnsService {

    @Autowired
    SnsDao dao;

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

    // sns 등록
    @Override
    @Transactional
    public SnsResultDto snsInsert(SnsDto dto) {

        SnsResultDto snsResultDto = new SnsResultDto();

        try {

            dao.snsInsert(dto); // dto는 키값

            dto.setSnsNo(dao.snsNoselect());
            dao.snsCheck(dto.getSnsNo());

            snsResultDto.setDto(dto);
            snsResultDto.setResult(SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            snsResultDto.setResult(FAIL);
        }

        return snsResultDto;
    }

    // sns 이미지 등록
    @Override
    public SnsResultDto snsImageInsert(int snsNo, List<MultipartFile> multipartFile) {

        SnsResultDto snsResultDto = new SnsResultDto();

        try {
            for (MultipartFile files : multipartFile) {

                String fileName = files.getOriginalFilename();
                fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));

                File file = this.convertToFile(files, fileName);
                String TEMP_URL = this.uploadFile(file, fileName);
                // 이미지 넣어버리기
                SnsImageDto snsImageDto = new SnsImageDto();
                snsImageDto.setSnsNo(snsNo);
                snsImageDto.setSnsImageUrl(TEMP_URL);
                file.delete();
                dao.snsImageInsert(snsImageDto);

            }
            snsResultDto.setImageList(dao.snsImageList(snsNo));
            snsResultDto.setResult(SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            snsResultDto.setResult(FAIL);
        }

        return snsResultDto;
    }

    // sns 업데이트
    @Override
    @Transactional
    public SnsResultDto snsUpdate(SnsDto dto) {

        SnsResultDto snsResultDto = new SnsResultDto();

        try {
            dao.snsUpdate(dto);

            snsResultDto.setResult(SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            snsResultDto.setResult(FAIL);
        }

        return snsResultDto;
    }

    // sns 이미지 업데이트
    @Override
    public SnsResultDto snsImageUpdate(int snsNo, List<MultipartFile> multipartFile) {
        SnsResultDto snsResultDto = new SnsResultDto();

        try {
            dao.snsImageDelete(snsNo);

            for (MultipartFile files : multipartFile) {

                String fileName = files.getOriginalFilename();
                fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));

                File file = this.convertToFile(files, fileName);
                String TEMP_URL = this.uploadFile(file, fileName);
                // 이미지 넣어버리기
                SnsImageDto snsImageDto = new SnsImageDto();
                snsImageDto.setSnsNo(snsNo);
                snsImageDto.setSnsImageUrl(TEMP_URL);

                dao.snsImageInsert(snsImageDto);

                snsResultDto.setResult(SUCCESS);
            }

        } catch (Exception e) {
            e.printStackTrace();
            snsResultDto.setResult(FAIL);
        }

        return snsResultDto;
    }

    // sns 이미지 없을때 업데이트
    @Override
    public SnsResultDto snsImageNullUpdate(int snsNo) {

        SnsResultDto snsResultDto = new SnsResultDto();

        try {
            dao.snsImageDelete(snsNo);

            snsResultDto.setResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            snsResultDto.setResult(FAIL);
        }
        return snsResultDto;
    }

    // 리스트를 생성하고 sns와 user를 join한 값들을 list에 순차적으로 저장(count는 sns에 있는 튜플의 개수로 지정)
    @Override
    public SnsResultDto snsList(SnsParamDto snsParamDto) {

        SnsResultDto snsResultDto = new SnsResultDto();

        try {
            List<SnsDto> list = dao.snsList(snsParamDto);

            int count = dao.snsListTotalCount();
            for (int i = 0; i < count; i++) {
                List<SnsImageDto> imageList = dao.snsImageList(list.get(i).getSnsNo());
                list.get(i).setImageList(imageList);
                // System.out.println(snsResultDto);
                List<SnsReplyDto> snsReplyList = dao.snsReplyList(list.get(i).getSnsNo());
                list.get(i).setReplyList(snsReplyList);
            }
            snsResultDto.setList(list);
            snsResultDto.setCount(count);
            snsResultDto.setResult(SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            snsResultDto.setResult(FAIL);
        }

        return snsResultDto;
    }

    @Override
    public SnsResultDto snsListSearchWord(SnsParamDto dto) {

        SnsResultDto snsResultDto = new SnsResultDto();

        try {
            List<SnsDto> list = dao.snsListSearchWord(dto.getSearchWord());
            int count = dao.snsListSearchWordTotalCount(dto.getSearchWord());
            for (int i = 0; i < count; i++) {
                List<SnsImageDto> imageList = dao.snsImageList(list.get(i).getSnsNo());
                list.get(i).setImageList(imageList);

                List<SnsReplyDto> snsReplyList = dao.snsReplyList(list.get(i).getSnsNo());
                list.get(i).setReplyList(snsReplyList);
            }
            // List<SnsReplyDto> replyList = dao.snsReplyList
            snsResultDto.setList(list);
            snsResultDto.setCount(count);
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
            // 로컬에 저장된 이미지 삭제
            System.out.println("delete serviceImpl");
            // snsImageDelete(snsNo);
            // 댓글 삭제;
            dao.snsDelete(snsNo); // 마지막으로 글 삭제

            snsResultDto.setResult(SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            snsResultDto.setResult(FAIL);
        }

        return snsResultDto;
    }

    @Override
    public SnsResultDto snsDetail(SnsParamDto snsParamDto) {
        SnsResultDto snsResultDto = new SnsResultDto();

        try {

            SnsDto snsDto = dao.snsDetail(snsParamDto);

            snsDto.setImageList(dao.snsImageList(snsParamDto.getSnsNo()));
            snsDto.setReplyList(dao.snsReplyList(snsParamDto.getSnsNo()));
            // 이미지 리스트 불러와주기

            snsResultDto.setDto(snsDto);
            snsResultDto.setResult(SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            snsResultDto.setResult(FAIL);
        }

        return snsResultDto;
    }

}
