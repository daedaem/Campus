package com.ssafy.project.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SnsReplyResultDto {
    private int result;
    private int count;
    private List<SnsReplyDto> list;
}
