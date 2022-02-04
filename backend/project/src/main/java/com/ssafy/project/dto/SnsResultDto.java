package com.ssafy.project.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SnsResultDto {
    private int result;
    private SnsDto dto;
    private List<SnsDto> list;
    private List<SnsImageDto> imageList;
    //private 
    private int count;
}
