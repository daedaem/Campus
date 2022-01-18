package com.ssafy.project.dao;

import java.util.List;

import com.ssafy.project.dto.SnsDto;
import com.ssafy.project.dto.SnsImageDto;
import com.ssafy.project.dto.SnsParamDto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SnsDao {
    public int snsInsert(SnsDto snsNo);
    public int snsDelete(int snsNo);
    public int snsUpdate(SnsDto dto);

    public List<SnsDto> snsList(SnsParamDto dto);
    public List<SnsDto> snsListSearchWord(SnsParamDto dto);

    public List<SnsImageDto> snsImageList(int snsImageNo);
    public int snsImageInsert(SnsImageDto dto);
    public int snsImageDelete(int snsNo);
    public List<String> snsImageUrlDeleteList(int snsNo);

    public int snsLikeInsert(
            @Param("snsNo") int snsNo,
            @Param("userNo") int userNo
    );
    public int snsLikeDelete(int snsNo);

    
}
