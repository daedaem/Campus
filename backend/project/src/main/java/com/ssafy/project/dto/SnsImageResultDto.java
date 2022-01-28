package com.ssafy.project.dto;

import java.util.List;

import lombok.Data;

@Data
public class SnsImageResultDto {
    private int result;
    private int snsImageNo;
    private SnsImageDto dto;
    private List<SnsImageDto> list;
}
