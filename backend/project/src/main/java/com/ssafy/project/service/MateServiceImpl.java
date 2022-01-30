package com.ssafy.project.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.List;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.ssafy.project.dao.MateDao;
import com.ssafy.project.dto.MateDto;
import com.ssafy.project.dto.MateParamDto;
import com.ssafy.project.dto.MateResultDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MateServiceImpl implements MateService {

    @Autowired
    MateDao dao;

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

    // @Override
    // public MateResultDto mateInsert(MateDto dto, MultipartHttpServletRequest
    // request) {

    // MateResultDto mateResultDto = new MateResultDto();

    // try {

    // List<MultipartFile> fileList = request.getFiles("file"); // file를
    // MultiparFile로 넘겨줌으로 각각의 파일이 filelist에 저장된다.

    // File uploadDir = new File(uploadPath + File.separator + uploadFolder); //
    // 경로지정
    // if (!uploadDir.exists()) uploadDir.mkdir(); // 만약 경로가 없다면 자동으로 만들어 준다.

    // for (MultipartFile part : fileList) {

    // String fileName = part.getOriginalFilename(); // 실제로 첨부했을때 file 이름

    // //Random File Id
    // UUID uuid = UUID.randomUUID(); // id가 중복되지 않도록 해준다.

    // //file extension
    // String extension = FilenameUtils.getExtension(fileName); // vs
    // FilenameUtils.getBaseName() // 확장자

    // String savingFileName = uuid + "." + extension; // 파일 이름과 확장자를 붙인다.

    // File destFile = new File(uploadPath + File.separator + uploadFolder +
    // File.separator + savingFileName); // 최종 경로

    // System.out.println(uploadPath + File.separator + uploadFolder +
    // File.separator + savingFileName);
    // part.transferTo(destFile); // part를 destFile쪽으로 넘긴다.

    // // Table Insert
    // dto.setFileName(fileName);
    // dto.setFileSize(part.getSize());
    // dto.setFileContentType(part.getContentType());
    // String matefileUrl = uploadFolder + "/" + savingFileName;
    // dto.setFileUrl(matefileUrl);

    // dao.mateInsert(dto);

    // }

    // mateResultDto.setResult(SUCCESS);

    // } catch (Exception e) {
    // e.printStackTrace();
    // mateResultDto.setResult(FAIL);
    // }

    // return mateResultDto;
    // }

    @Override
    public MateResultDto mateDelete(int mateNo) {
        MateResultDto mateResultDto = new MateResultDto();

        try {
            // List<String> fileUrlList = dao.mateFileUrlDeleteList(mateNo);
            // for(String fileUrl : fileUrlList) { // file 물리적 삭제
            // File file = new File(uploadPath + File.separator, fileUrl);
            // if(file.exists()) {
            // file.delete();
            // }
            // }

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

}
