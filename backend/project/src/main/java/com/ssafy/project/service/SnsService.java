package com.ssafy.project.service;

import com.ssafy.project.dto.SnsDto;
import com.ssafy.project.dto.SnsParamDto;
import com.ssafy.project.dto.SnsResultDto;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface SnsService {
    public SnsResultDto snsInsert(SnsDto dto, MultipartHttpServletRequest request);

    public SnsResultDto snsList(SnsParamDto snsParamDto);

    public SnsResultDto snsUpdate(SnsDto dto, MultipartHttpServletRequest request);

    public SnsResultDto Delete(int snsNo);
}
