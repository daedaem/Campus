package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.dto.SnsDto;
import com.ssafy.project.dto.SnsParamDto;
import com.ssafy.project.dto.SnsResultDto;

import org.springframework.web.multipart.MultipartFile;

public interface SnsService {
    // 글생성
    public SnsResultDto snsInsert(SnsDto dto);
    // 리스트 보여주
    public SnsResultDto snsList(SnsParamDto snsParamDto);

    public SnsResultDto snsUpdate(SnsDto dto);

    public SnsResultDto snsImageUpdate(int snsNo, List<MultipartFile> multipartFile);

    public SnsResultDto snsImageNullUpdate(int snsNo);

    public SnsResultDto snsDelete(int snsNo);

    public SnsResultDto snsListSearchWord(SnsParamDto snsParamDto);

    public SnsResultDto snsDetail(SnsParamDto snsParamDto);

    public SnsResultDto snsImageInsert(int snsNo, List<MultipartFile> multipartFile);

}
