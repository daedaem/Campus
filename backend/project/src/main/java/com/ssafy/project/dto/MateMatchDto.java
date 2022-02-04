package com.ssafy.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MateMatchDto {
    private int userNo;
    private String userEmail;
    private String userNickname;
    private String userProfileImage;
    private String userGender;
    private String userMBTI;
    

    private char campStyle1;
    private char campStyle2;
    private char campStyle3;
    private char campStyle4;
    private char campStyle5;
    private char campStyle6;
}
