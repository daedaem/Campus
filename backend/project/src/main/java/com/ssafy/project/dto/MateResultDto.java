package com.ssafy.project.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MateResultDto {
    private int result;
    private MateDto dto;
    private List<MateDto> list;
    private int count;
}
