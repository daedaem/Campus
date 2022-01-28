package com.ssafy.project.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import com.ssafy.project.dao.MateDao;
import com.ssafy.project.dto.MateDto;
import com.ssafy.project.dto.MateParamDto;
import com.ssafy.project.dto.MateResultDto;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class MateServiceImpl implements MateService {

    @Autowired
    MateDao dao;

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    // @Value("${app.fileupload.uploadDir}")
    // String uploadFolder;

    // @Value("${app.fileupload.uploadPath}")
    // String uploadPath;

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
