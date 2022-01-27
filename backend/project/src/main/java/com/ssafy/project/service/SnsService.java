package com.ssafy.project.service;

import com.ssafy.project.dto.SnsDto;
import com.ssafy.project.dto.SnsParamDto;
import com.ssafy.project.dto.SnsResultDto;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface SnsService {
    // 글생성
    public SnsResultDto snsInsert(SnsDto dto, MultipartHttpServletRequest request);
    // 리스트 보여주
    public SnsResultDto snsList(SnsParamDto snsParamDto);

    public SnsResultDto snsUpdate(SnsDto dto, MultipartHttpServletRequest request);

    public SnsResultDto snsDelete(int snsNo);

    public SnsResultDto snsListSearchWord(SnsParamDto snsParamDto);
}
