package com.ssafy.project.dao;

import java.util.List;

import com.ssafy.project.dto.MateCampEquipRequiredDto;
import com.ssafy.project.dto.MateCampStyleDto;
import com.ssafy.project.dto.MateDto;
import com.ssafy.project.dto.MateListDto;
import com.ssafy.project.dto.MateMatchDto;
import com.ssafy.project.dto.MateParamDto;
import com.ssafy.project.dto.SnsImageDto;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface MateDao {
    
    public int mateInsert(MateDto dto);
    public int mateDelete(int mateNo);
    public int mateUpdate(MateDto dto);

    public List<MateDto> mateList(MateParamDto mateParamDto);

    public List<String> mateFileUrlDeleteList(int mataNo);

    public int mateListTotalCount();

    public void campStyleListInsert(MateCampStyleDto dto);

    public void campEquipReuireListInsert(MateCampEquipRequiredDto dto);

    public void campStyleListUpdate(MateCampStyleDto dto);

    public void campEquipReuireListUpdate(MateCampEquipRequiredDto dto);

    public void mateImageDelete(int mateNo);

    public MateDto mateDetail(int mateNo);

    public MateCampStyleDto mateCampStyleList(int mateNo);

    public List<MateListDto> mateApplyList(int mateNo);

    public MateCampEquipRequiredDto  mateCampEquipRequiredList(int mateNo);

    public List<SnsImageDto> mateSnsImageList(int userNo);

    public int mateNoselect();

    public String userMBTIselect(int userNo);

    public int mateCheck(int mateNo);

    public void mateApplyInsert(MateListDto dto);

    public void mateApplyDelete(int mateListNo);

    public List<MateListDto> userCampStyle(int userNo);

    public void mateImageInsert(MateDto dto);

    public List<MateMatchDto> mateMatchList(MateMatchDto dto);
    
}
