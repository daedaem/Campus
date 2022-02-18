package com.ssafy.project.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SnsImageResultDto {
    private int result;
    private int snsImageNo;
    private SnsImageDto dto;
    private List<SnsImageDto> list;
}
