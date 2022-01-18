package com.ssafy.project.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SnsResultDto {
    private int result;
    private SnsDto dto;
    private List<SnsDto> list;
}
