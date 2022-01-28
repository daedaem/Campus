package com.ssafy.project.dto;

import java.util.List;

import lombok.Data;

@Data
public class MateResultDto {
    private int result;
    private MateDto dto;
    private List<MateDto> list;
    private int count;
}
