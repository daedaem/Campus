package com.ssafy.project.dto;

import java.util.List;

import lombok.Data;

@Data
public class CampRateResultDto {
    private int result;
    private CampRateDto dto;
    private List<CampRateDto> list;
    private int count;
}
