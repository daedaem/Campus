package com.ssafy.project.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampLikeResultDto {
    private int userNo;
    private List<CampSiteDto> campLikeList;
    private int result;
}
