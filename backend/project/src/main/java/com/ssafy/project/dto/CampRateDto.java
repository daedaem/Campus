package com.ssafy.project.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampRateDto {
    private int campRateNo;
    private String contentId;
    private int campRateCleanliness;
    private int campRatePrice;
    private int campRateFacility;
    private int userNo;
    private String campRateContent;
    private Date campRateCreateTime;
    private Date campRateUpdateTime;
    private String campRateTitle;
    private String userNickname;
    private boolean sameUser;
}
