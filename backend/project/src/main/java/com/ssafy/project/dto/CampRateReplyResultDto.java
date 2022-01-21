package com.ssafy.project.dto;

import java.util.List;

import lombok.Data;

@Data
public class CampRateReplyResultDto {
    private int result;
    private List<CampRateReplyDto> list;
    private int count;
}
