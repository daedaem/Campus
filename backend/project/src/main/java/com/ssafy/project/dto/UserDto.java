package com.ssafy.project.dto;

import lombok.Data;

@Data
public class UserDto {
    private int userNo;
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userProfileImage;
    private String userLocation;
    private int userAge;
    private String userGender;
    private String userNickname;
    private String userMBTI;
}
