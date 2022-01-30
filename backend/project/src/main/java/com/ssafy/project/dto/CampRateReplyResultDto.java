package com.ssafy.project.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampRateReplyResultDto {
    private int result;
    private List<CampRateReplyDto> list;
    private int count;
}
