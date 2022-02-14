package com.ssafy.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MateListDto {
    private int mateNo;
    private int userNo;
    private String userNickname;
    private int mateListNo;
    private int userAge;
    private int mateListNum;
    private String userGender;
    private String userMBTI;
    private int userRatePoint;
    private int mateApplyCheck;
    private char campStyle1;
    private char campStyle2;
    private char campStyle3;
    private char campStyle4;
    private char campStyle5;
    private char campStyle6;
}
