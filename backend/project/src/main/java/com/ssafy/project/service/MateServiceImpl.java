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
import com.ssafy.project.dao.ChatRoomMapper;
import com.ssafy.project.dao.MateDao;
import com.ssafy.project.dao.MessageMapper;
import com.ssafy.project.dao.SnsDao;
import com.ssafy.project.dto.ChatRoom;
import com.ssafy.project.dto.MateCampEquipRequiredDto;
import com.ssafy.project.dto.MateCampStyleDto;
import com.ssafy.project.dto.MateDto;
import com.ssafy.project.dto.MateListDto;
import com.ssafy.project.dto.MateMatchDto;
import com.ssafy.project.dto.MateMatchResultDto;
import com.ssafy.project.dto.MateParamDto;
import com.ssafy.project.dto.MateResultDto;
import com.ssafy.project.dto.Message;
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

    @Autowired
    ChatRoomMapper chatMapper;

    @Autowired
    MessageMapper messageMapper;

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
    public MateResultDto mateInsert(MateDto dto) {

    MateResultDto mateResultDto = new MateResultDto();

    try {
       
        dao.mateInsert(dto);
        
        dto.setMateNo(dao.mateNoselect());
        dao.mateCheck(dao.mateNoselect());

        dto.getCampStyleList().setMateNo(dto.getMateNo());
        dao.campStyleListInsert(dto.getCampStyleList());

        dto.getCampEquipRequiredList().setMateNo(dto.getMateNo());
        dao.campEquipReuireListInsert(dto.getCampEquipRequiredList());
        System.out.println("!!!!" + dto);
        // 모집글 생성후 바로 채팅방 생성(채팅방 생성자는 모집하는 사람)
        ChatRoom chatroom = new ChatRoom();
        chatroom.setTitle(dto.getMateTitle());
        chatroom.setMasterId(dto.getUserNo());
        chatMapper.createRoom(chatroom);
        // 생성자는 바로 메세지를 보내 자신이 방에 참가 함
        Message message = new Message();
        // String content = dto.getUserNickName() +"님이 참가하셨습니다.";
        message.setSenderId(dto.getUserNo());
        message.setContent(dto.getUserNickname() +"님이 참가하셨습니다.");
        messageMapper.insertMessage(message);

        mateResultDto.setDto(dto);
 
        mateResultDto.setResult(SUCCESS);

    } catch (Exception e) {
    e.printStackTrace();
    mateResultDto.setResult(FAIL);
    }

    return mateResultDto;
    }

    @Override
    public MateResultDto mateImageInsert(int mateNo, MultipartFile multipartFile) {
        
        MateResultDto mateResultDto = new MateResultDto();
        
        try {
            String fileName = multipartFile.getOriginalFilename();
            System.out.println(fileName);
            fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));
            File file = this.convertToFile(multipartFile, fileName);
            String TEMP_URL = this.uploadFile(file, fileName);

            System.out.println(TEMP_URL);

            MateDto dto = new MateDto();
            dto.setMateNo(mateNo);
            dto.setMateImageUrl(TEMP_URL);
            System.out.println(dto.getMateImageUrl());
            dao.mateImageInsert(dto);
            

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
    public MateResultDto mateUpdate(MateDto dto) {
        MateResultDto mateResultDto = new MateResultDto();

        try {

            dao.mateUpdate(dto);
            dao.campStyleListUpdate(dto.getCampStyleList());
            dao.campEquipReuireListUpdate(dto.getCampEquipRequiredList());

            mateResultDto.setResult(SUCCESS);
            
        } catch (Exception e) {
            e.printStackTrace();
            mateResultDto.setResult(FAIL);
        }
        return mateResultDto;
    }

    @Override
    public MateResultDto mateImageUpdate(int mateNo, MultipartFile multipartFile) {
        MateResultDto mateResultDto = new MateResultDto();
        try {
            dao.mateImageDelete(mateNo);

            String fileName = multipartFile.getOriginalFilename();
            System.out.println(fileName);
            fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));
            File file = this.convertToFile(multipartFile, fileName);
            String TEMP_URL = this.uploadFile(file, fileName);

            System.out.println(TEMP_URL);

            MateDto dto = new MateDto();
            dto.setMateNo(mateNo);
            dto.setMateImageUrl(TEMP_URL);
            dao.mateImageInsert(dto);
            

            mateResultDto.setResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            mateResultDto.setResult(FAIL);
        }
        return mateResultDto;
    }

    @Override
    public MateResultDto mateImageUpdateNull(int mateNo) {
        MateResultDto mateResultDto = new MateResultDto();
        try {
            dao.mateImageDelete(mateNo);

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
            for (MateDto mateDto : list) {
                //mateDto.getMateNo()
                MateCampStyleDto campStyleList = dao.mateCampStyleList(mateDto.getMateNo());
                mateDto.setCampStyleList(campStyleList);

                List<MateListDto> mateApplyList = dao.mateApplyList(mateDto.getMateNo());
                System.out.println(mateApplyList);
                mateDto.setMateList(mateApplyList);


            }
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

    @Override
    public MateResultDto mateListInsert(MateListDto dto) {
        
        MateResultDto mateResultDto = new MateResultDto();
        
        try {
           dao.mateApplyInsert(dto);

           Message message = new Message();
           message.setSenderId(dto.getUserNo());
           message.setChatroomId(dto.getMateNo());
           message.setContent(dto.getUserNickname() + "님이 입장하셨습니다.");
           messageMapper.insertMessage(message);

           mateResultDto.setResult(SUCCESS);
       } catch (Exception e) {
            e.printStackTrace();
            mateResultDto.setResult(FAIL);
       }
        return mateResultDto;
    }

    @Override
    public MateResultDto mateApplyDelete(int mateListNo) {
        
        MateResultDto mateResultDto = new MateResultDto();

        try {

            dao.mateApplyDelete(mateListNo);
            mateResultDto.setResult(SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            mateResultDto.setResult(FAIL);
        }
        return mateResultDto;
    }

    @Override
    public MateMatchResultDto mateMatch(int userNo) {
        MateMatchResultDto mateMatchResultDto = new MateMatchResultDto();

        try {
            MateMatchDto matchDto = new MateMatchDto();
            matchDto.setUserNo(userNo);
            matchDto.setUserMBTI(dao.userMBTIselect(userNo));

            mateMatchResultDto.setMatelist(dao.mateMatchList(matchDto));
            
            mateMatchResultDto.setResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            mateMatchResultDto.setResult(FAIL);
        }

        return mateMatchResultDto;
    }

    @Override
    public MateResultDto mateListMain(MateParamDto mateParamDto) {
        
        MateResultDto mateResultDto = new MateResultDto();

        try {
            
            mateResultDto.setList(dao.mateListMain(mateParamDto));
            mateResultDto.setResult(SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            mateResultDto.setResult(FAIL);
        }
        return mateResultDto;
    }









}
