package com.ssafy.project.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.ArrayList;
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
import com.ssafy.project.dto.DemoDto;
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

import org.apache.ibatis.javassist.expr.NewArray;
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
        
        // 모집글 생성후 바로 채팅방 생성(채팅방 생성자는 모집하는 사람)
        ChatRoom chatroom = new ChatRoom();
        chatroom.setTitle(dto.getMateTitle());
        chatroom.setMasterId(dto.getUserNo());
        chatMapper.createRoom(chatroom);
        // 생성자는 바로 메세지를 보내 자신이 방에 참가 함
        Message message = new Message();
        // String content = dto.getUserNickName() +"님이 참가하셨습니다.";
        message.setChatroomId(chatMapper.getRoomId(dto.getMateTitle()));// 채팅방 아이디를 가져와야함
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
            file.delete();

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
            System.out.println(mateApplyList);
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
            System.out.println(dto);
           dao.mateApplyInsert(dto);

           Message message = new Message();
           message.setSenderId(dto.getUserNo());
           String test = dao.getMateTitle(dto.getMateNo());
           System.out.println(test);
           long test2 = chatMapper.getRoomId(dao.getMateTitle(dto.getMateNo()));
           System.out.println(test2);
           message.setChatroomId(chatMapper.getRoomId(dao.getMateTitle(dto.getMateNo())));
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
            MateMatchDto matchDto = dao.userMBTIselect(userNo);
            List<MateMatchDto> list = dao.mateMatchList(matchDto);

            // 매치된 인원이 4보다 작으면 모든 유저에서 매칭
            if(list.size() < 4){
                list = dao.mateMatchListAll(matchDto);
                for(int i = 0 ; i < list.size() ; i++){
                    int result = 0;
                    int value = dao.userMatchValue(matchDto.getUserMBTI(), list.get(i).getUserMBTI());
                    int count = 0;
                    if(matchDto.getCampStyle1() == 'Y' && list.get(i).getCampStyle1() == 'Y' ) count++;
                    if(matchDto.getCampStyle2() == 'Y' && list.get(i).getCampStyle2() == 'Y' ) count++;
                    if(matchDto.getCampStyle3() == 'Y' && list.get(i).getCampStyle3() == 'Y' ) count++;
                    if(matchDto.getCampStyle4() == 'Y' && list.get(i).getCampStyle4() == 'Y' ) count++;
                    if(matchDto.getCampStyle5() == 'Y' && list.get(i).getCampStyle5() == 'Y' ) count++;
                    if(matchDto.getCampStyle6() == 'Y' && list.get(i).getCampStyle6() == 'Y' ) count++;
                    System.out.println(i + " 번째 : " +count + "    " + value);
                    result = count + value;
                    if( result == 7 || result == 8) result += 1;
                    else if( result == 5 || result == 6) result += 3;
                    list.get(i).setCampStyleScore(result);
                }
                mateMatchResultDto.setMatelist(list);
            }else{
                for(int i = 0 ; i < list.size() ; i++){
                    int result = 0;
                    int value = dao.userMatchValue(matchDto.getUserMBTI(), list.get(i).getUserMBTI());
                    int count = 0;
                    if(matchDto.getCampStyle1() == 'Y' && list.get(i).getCampStyle1() == 'Y' ) count++;
                    if(matchDto.getCampStyle2() == 'Y' && list.get(i).getCampStyle2() == 'Y' ) count++;
                    if(matchDto.getCampStyle3() == 'Y' && list.get(i).getCampStyle3() == 'Y' ) count++;
                    if(matchDto.getCampStyle4() == 'Y' && list.get(i).getCampStyle4() == 'Y' ) count++;
                    if(matchDto.getCampStyle5() == 'Y' && list.get(i).getCampStyle5() == 'Y' ) count++;
                    if(matchDto.getCampStyle6() == 'Y' && list.get(i).getCampStyle6() == 'Y' ) count++;
                    System.out.println(i + " 번째 : " +count + "    " + value);
                    result = count + value;
                    if( result == 7 || result == 8) result += 2;
                    else if( result == 5 || result == 6) result += 3;
                    else if( result == 3 || result == 4 ) result += 4;
                    list.get(i).setCampStyleScore(result);
                }
                mateMatchResultDto.setMatelist(list);
            }
            
            
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
            List<MateDto> list = dao.mateListMain(mateParamDto);

            for (MateDto mateDto : list) {
                mateDto.setMateList(dao.mateApplyList(mateDto.getMateNo()));
            }
            mateResultDto.setList(list);
            mateResultDto.setResult(SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            mateResultDto.setResult(FAIL);
        }
        return mateResultDto;
    }

    @Override
    public MateResultDto mateStatusUpdate(int mateNo) {
        MateResultDto mateResultDto = new MateResultDto();

        try {
            
            dao.mateStatusUpdate(mateNo);
            mateResultDto.setResult(SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            mateResultDto.setResult(FAIL);
        }
        return mateResultDto;
    }

    @Override
    public MateResultDto mateFilter(MateDto dto) {
        MateResultDto mateResultDto = new MateResultDto();

        try {
            // 캠프 타입 일치하는 mateNo list 반환
            List<Integer> list1 = dao.mateFilterCampType(dto);
            System.out.println("list1 : " + list1);
            // 캠프 날짜에 포함되는 mateNo list 반환
            List<Integer> list2 = dao.mateFilterCampDate(dto);
            System.out.println("list2 : " + list2);
            //들어가있는 스타일 개수에 따라 matNo list 반환
            List<Integer> list3 = new ArrayList<Integer>();
            System.out.println(dto.getCampStyleList());
            if(dto.getCampStyleList() != null){
                if(dto.getCampStyleList().getStyle3() != null){
                    list3 = dao.mateFilterStyleNum3(dto.getCampStyleList());
                }else if(dto.getCampStyleList().getStyle2() != null){
                    list3 = dao.mateFilterStyleNum2(dto.getCampStyleList());
                }else if(dto.getCampStyleList().getStyle1() != null){
                    list3 = dao.mateFilterStyleNum1(dto.getCampStyleList());
                }
                System.out.println("list3 : " + list3);
            }else{
                list3 = new ArrayList<Integer>();
                list3.clear();
                System.out.println("list3 : " + list3);
            }

            List<Integer> listResult = new ArrayList<Integer>();
            System.out.println(dto.getCampStyleList());
            if(dto.getCampStyleList().getStyle1() != null){ // 스타일 리스트가 있지만 결과 값이 0일때
                if(list3.size() == 0){
                    System.out.println("제발");
                    listResult = list3;
                }else{
                    if(list1.size() == 0){
                        if(list2.size() == 0){
                            listResult = list3;
                        }else{
                            for (int i = 0; i < list2.size(); i++) {
                                for (int j = 0; j < list3.size(); j++) {
                                    if(list2.get(i).equals(list3.get(j)))
                                        listResult.add(list2.get(i));
                                }
                            }
                        }
                    }else{
                        if(list2.size() == 0){
                            for (int i = 0; i < list1.size(); i++) {
                                for (int j = 0; j < list3.size(); j++) {
                                    if(list1.get(i).equals(list3.get(j)))
                                        listResult.add(list1.get(i));
                                }
                            }
                        }else{
                            for (int i = 0; i < list1.size(); i++) {
                                for (int j = 0; j < list2.size(); j++) {
                                    for (int k = 0; k < list3.size(); k++) {
                                        if(list1.get(i).equals(list2.get(j)) && list2.get(j).equals(list3.get(k))){
                                            listResult.add(list1.get(i));
                                        }
                                    }
                                }
                            }
                            
                        }
                    }
                }
            }else{ // 스타일 리스트가 완전히 없을때
                if(list1.size() == 0){
                    if(list2.size() == 0){
                        listResult = list2;
                    }else{
                        listResult = list2;
                    }
                }else{
                    if(list2.size() == 0){
                        listResult = list1;
                    }else{
                        for (int i = 0; i < list1.size(); i++) {
                            for (int j = 0; j < list2.size(); j++) {
                                if(list1.get(i).equals(list2.get(j))){
                                    listResult.add(list1.get(i));
                                }
                            }
                        }
                    }
                }
            }
            

            if(listResult.size() == 0){
                dto.setMatefilter(-1);
                mateResultDto.setDto(dto);
            }else{
                DemoDto demoList = new DemoDto();
                demoList.setDemoList(listResult);
                System.out.println(demoList);
                List<MateDto> list = dao.mateFilterResult(demoList);
                mateResultDto.setList(list);
                for (MateDto mateDto : list) {
                    MateCampStyleDto campStyleList = dao.mateCampStyleList(mateDto.getMateNo());
                    mateDto.setCampStyleList(campStyleList);
    
                    List<MateListDto> mateApplyList = dao.mateApplyList(mateDto.getMateNo());
                    mateDto.setMateList(mateApplyList);
    
    
                }
            }

            mateResultDto.setResult(SUCCESS);


        } catch (Exception e) {
            e.printStackTrace();
            mateResultDto.setResult(FAIL);
        }
        return mateResultDto;
    }

    @Override
    public MateResultDto mateApplyCheck(int mateListNo) {
        MateResultDto mateResultDto = new MateResultDto();
        try {
            dao.mateApplyCheck(mateListNo);

            mateResultDto.setResult(SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            mateResultDto.setResult(FAIL);
        }
        return mateResultDto;
    }




}
