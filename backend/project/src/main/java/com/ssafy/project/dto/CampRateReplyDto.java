package com.ssafy.project.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampRateReplyDto {
    private int campRateReplyNo;
    private int campRateNo;
    private Date campRateReplyCreateTime;
    private Date campRateReplyUpdateTime;
    private String campRateReplyContent;
    private int userNo;
    private String userProfileImage;
    private String userNickname;
}
