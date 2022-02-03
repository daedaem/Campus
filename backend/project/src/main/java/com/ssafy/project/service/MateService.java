package com.ssafy.project.service;

import com.ssafy.project.dto.MateDto;
import com.ssafy.project.dto.MateListDto;
import com.ssafy.project.dto.MateParamDto;
import com.ssafy.project.dto.MateResultDto;

import org.springframework.web.multipart.MultipartFile;

public interface MateService {

    public MateResultDto mateInsert(MateDto dto, MultipartFile multipartFile);

    public MateResultDto mateDelete(int mateNo);

    public MateResultDto mateList(MateParamDto mateParamDto);

    public MateResultDto mateDetail(int mateNo);

    public MateResultDto mateListInsert(MateListDto dto);

}
