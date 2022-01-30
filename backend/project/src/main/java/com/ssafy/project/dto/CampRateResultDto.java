package com.ssafy.project.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampRateResultDto {
    private int result;
    private CampRateDto dto;
    private List<CampRateDto> list;
    private int count;
}
