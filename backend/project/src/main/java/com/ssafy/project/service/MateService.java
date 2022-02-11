package com.ssafy.project.service;

import com.ssafy.project.dto.MateDto;
import com.ssafy.project.dto.MateListDto;
import com.ssafy.project.dto.MateMatchResultDto;
import com.ssafy.project.dto.MateParamDto;
import com.ssafy.project.dto.MateResultDto;

import org.springframework.web.multipart.MultipartFile;

public interface MateService {

    public MateResultDto mateInsert(MateDto dto);

    public MateResultDto mateImageInsert(int mateNo, MultipartFile multipartFile);

    public MateResultDto mateDelete(int mateNo);

    public MateResultDto mateUpdate(MateDto dto);

    public MateResultDto mateImageUpdate(int mateNo, MultipartFile multipartFile);

    public MateResultDto mateImageUpdateNull(int mateNo);

    public MateResultDto mateList(MateParamDto mateParamDto);

    public MateResultDto mateDetail(int mateNo);

    public MateResultDto mateListInsert(MateListDto dto);

    public MateResultDto mateApplyDelete(int mateListNo);

    public MateMatchResultDto mateMatch(int userNo);

    public MateResultDto mateListMain(MateParamDto mateParamDto);

    public MateResultDto mateStatusUpdate(int mateNo);

    public MateResultDto mateFilter(MateDto dto);

}
