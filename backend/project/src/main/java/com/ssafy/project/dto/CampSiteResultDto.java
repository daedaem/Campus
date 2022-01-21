package com.ssafy.project.dto;

import java.util.List;

import lombok.Data;

@Data
public class CampSiteResultDto {
    private int result;
    private CampSiteDto dto;
    private List<CampSiteDto> list;
    private int count;
}
