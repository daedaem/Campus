package com.ssafy.project.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.UUID;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.ssafy.project.dao.UserDao;
import com.ssafy.project.dto.UserDto;
import com.ssafy.project.dto.UserRateDto;
import com.ssafy.project.dto.UserResultDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    // userEmail에 해당하는 user정보 return
    @Override
    public UserDto userSelect(String userEmail) {
        UserDto dto = null;
        dto = userDao.userSelect(userEmail);
        System.out.println(dto);
        return dto;
    }

    // 회원가입
    @Override
    public UserResultDto userRegister(UserDto userDto) {
        UserResultDto userResultDto = new UserResultDto();
        if (userDao.userInsert(userDto) == SUCCESS) { // 가입 성공
            userResultDto.setResult(SUCCESS);
        } else { // 가입 실패
            userResultDto.setResult(FAIL);
        }
        return userResultDto;
    }

    // user정보 업데이트
    @Override
    public UserResultDto userUpdate(UserDto userDto) {
        UserResultDto userResultDto = new UserResultDto();
        if (userDao.userUpdate(userDto) == 3) { // 수정 성공
            userResultDto.setResult(SUCCESS);
        } else { // 수정 실패
            userResultDto.setResult(FAIL);
        }
        return userResultDto;
    }

    // 가입 시 user 세부 정보 입력
    @Override
    public UserResultDto userUpdateCamp(UserDto userDto) {
        UserResultDto userResultDto = new UserResultDto();
        if (userDao.userUpdateCamp(userDto) == SUCCESS) { // 수정 성공
            userResultDto.setResult(SUCCESS);
        } else { // 수정 실패
            userResultDto.setResult(FAIL);
        }
        return userResultDto;
    }

    // 가입 시 mbti
    @Override
    public UserResultDto userUpdateMBTI(UserDto userDto) {
        UserResultDto userResultDto = new UserResultDto();
        if (userDao.userUpdateMBTI(userDto) == SUCCESS) { // 수정 성공
            userResultDto.setResult(SUCCESS);
        } else { // 수정 실패
            userResultDto.setResult(FAIL);
        }
        return userResultDto;
    }

    private String uploadFile(File file, String fileName) throws IOException { // 파일 업로드를 위해 사용
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

    private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException { // multipartfile을
                                                                                                  // file로 변환
        File tempFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
            fos.close();
        }
        return tempFile;
    }

    private String getExtension(String fileName) { // 업로드 파일의 extension을 얻기 위해 사용
        return fileName.substring(fileName.lastIndexOf("."));
    }

    // 이미지 업로드 테스트
    // @Override
    // public String userUpdateProfileImage(MultipartFile multipartFile) {
    // try {
    // String fileName = multipartFile.getOriginalFilename();
    // fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));

    // File file = this.convertToFile(multipartFile, fileName);
    // String TEMP_URL = this.uploadFile(file, fileName);
    // file.delete();
    // return TEMP_URL;
    // } catch (Exception e) {
    // e.printStackTrace();
    // return "FAIL";
    // }
    // }

    // 가입 시 이미지 등록
    @Override
    public UserResultDto userUpdateProfileImage(String userEmail, MultipartFile multipartFile) {
        UserResultDto userResultDto = new UserResultDto();
        try {
            String fileName = multipartFile.getOriginalFilename();
            fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));

            File file = this.convertToFile(multipartFile, fileName);
            String TEMP_URL = this.uploadFile(file, fileName);
            UserDto userDto = new UserDto();
            userDto.setUserEmail(userEmail);
            userDto.setUserProfileImage(TEMP_URL);
            file.delete();
            if (userDao.userUpdateProfileImage(userDto) == SUCCESS) {
                userResultDto.setResult(SUCCESS);
            } else {
                userResultDto.setResult(FAIL);
            }
            return userResultDto;
        } catch (Exception e) {
            e.printStackTrace();
            userResultDto.setResult(FAIL);
        }
        return userResultDto;
    }

    // userEmail에 해당하는 유저 정보 삭제
    @Override
    public UserResultDto userDelete(String userEmail) {
        UserResultDto userResultDto = new UserResultDto();
        if (userDao.userDelete(userEmail) != FAIL) { // 탈퇴 성공
            userResultDto.setResult(SUCCESS);
        } else { // 탈퇴 실패
            userResultDto.setResult(FAIL);
        }
        return userResultDto;
    }

    @Override
    public UserResultDto userRate(UserRateDto userRateDto) {
        UserResultDto userResultDto = new UserResultDto();
        if (userDao.userRate(userRateDto) == SUCCESS) {
            userResultDto.setResult(SUCCESS);
        } else {
            userResultDto.setResult(FAIL);
        }
        return userResultDto;
    }

    @Override
    public UserResultDto userDuplEmail(String userEmail) {
        UserResultDto userResultDto = new UserResultDto();
        if (userDao.userDuplEmail(userEmail) == 0) { // 중복되는 이메일이 없음
            userResultDto.setResult(SUCCESS);
        } else {
            userResultDto.setResult(FAIL);
        }
        return userResultDto;
    }

    @Override
    public UserResultDto userDuplNickname(String userNickname) {
        UserResultDto userResultDto = new UserResultDto();
        if (userDao.userDuplNickname(userNickname) == 0) { // 중복되는 닉네임이 없음
            userResultDto.setResult(SUCCESS);
        } else {
            userResultDto.setResult(FAIL);
        }
        return userResultDto;
    }

}
