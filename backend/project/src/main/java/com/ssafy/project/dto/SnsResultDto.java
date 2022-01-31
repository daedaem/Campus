package com.ssafy.project.dto;

import java.util.List;

import lombok.Data;

@Data
public class SnsResultDto {
    private int result;
    private SnsDto dto;
    private List<SnsDto> list;
    private List<SnsImageDto> imageList;
    //private 
    private int count;
}
