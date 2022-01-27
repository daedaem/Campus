package com.ssafy.project.service;

import com.ssafy.project.dto.MateDto;
import com.ssafy.project.dto.MateParamDto;
import com.ssafy.project.dto.MateResultDto;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface MateService {
    

    public MateResultDto mateInsert(MateDto dto, MultipartHttpServletRequest request);

    public MateResultDto mateDelete(int mateNo);

	public MateResultDto mateList(MateParamDto mateParamDto);


}
