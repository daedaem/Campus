package com.ssafy.project.dto;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MateDto {
    private int mateNo;
    private String mateTitle;
    private String mateCampsite;
    private int lowestAge;
    private int highestAge;
    private String mateContent;
    //private String mateCampstyle;
    private String mateCamptype;
    private Date mateCampstart;
    private Date mateCampend;
    private int userNo;
    private String userNickname;
    private int contentId;
    private String mateStatus;
    private int friendlimit;
    private int memberlimit;
    private String mateGender;


    private Date mateCreateTime;
    private Date mateUpdateTime;

    private String mateImageUrl;
    private String userProfileImage;
    private List<MateListDto> mateList;
    private List<SnsImageDto> imageList;
    //private List<MateCampStyleDto> campStyleList;
    //private List<MateCampEquipRequiredDto> campEquipRequiredList;
    private MateCampStyleDto campStyleList;
    private MateCampEquipRequiredDto campEquipRequiredList;

    // 캠핑장 평점 추가
    // 장비 리스트
    
}
