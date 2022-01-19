package com.ssafy.project.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class CampRateReplyDto {
    private int campRateReplyNo;
    private int campRateNo;
    private Date campRateReplyCreateTime;
    private Date campRateReplyUpdateTime;
    private String campRateReplyContent;
    private int userNo;
}
