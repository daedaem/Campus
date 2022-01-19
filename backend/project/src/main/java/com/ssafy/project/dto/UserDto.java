package com.ssafy.project.dto;

import lombok.Data;

@Data
public class UserDto {
    // user 테이블
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

    // campStyle 테이블
    private char campStyle1;
    private char campStyle2;
    private char campStyle3;
    private char campStyle4;
    private char campStyle5;
    private char campStyle6;

    // campEquip 테이블
    private String campEquipTent;
    private String campEquipSleepingBag;
    private String campEquipBurner;
    private String campEquipBrazier;
    private String campEquipEtc1;
    private String campEquipEtc2;
    private String campEquipEtc3;
    private String campEquipEtc4;
    private String campEquipEtc5;

    // userRate 테이블
    private double userRatePoint;
}
