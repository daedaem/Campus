package com.ssafy.project.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampSiteResultDto {
    private int result;
    private CampSiteDto dto;
    private List<CampSiteDto> list;
    private int count;
}
