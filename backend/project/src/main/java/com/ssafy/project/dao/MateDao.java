package com.ssafy.project.dao;

import java.util.List;

import com.ssafy.project.dto.MateCampEquipRequiredDto;
import com.ssafy.project.dto.MateCampStyleDto;
import com.ssafy.project.dto.MateDto;
import com.ssafy.project.dto.MateListDto;
import com.ssafy.project.dto.MateParamDto;
import com.ssafy.project.dto.SnsImageDto;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface MateDao {
    
    public int mateInsert(MateDto dto);
    public int mateDelete(int mateNo);
    public List<MateDto> mateList(MateParamDto mateParamDto);

    public List<String> mateFileUrlDeleteList(int mataNo);

    public int mateListTotalCount();

    public void campStyleListInsert(MateCampStyleDto dto);

    public void campEquipReuireListInsert(MateCampEquipRequiredDto dto);

    public MateDto mateDetail(int mateNo);

    public MateCampStyleDto mateCampStyleList(int mateNo);

    public List<MateListDto> mateApplyList(int mateNo);

    public MateCampEquipRequiredDto  mateCampEquipRequiredList(int mateNo);

    public List<SnsImageDto> mateSnsImageList(int userNo);

    public int mateNoselect();

    public int mateCheck(int mateNo);

    public void mateApplyInsert(MateListDto dto);
    
}
