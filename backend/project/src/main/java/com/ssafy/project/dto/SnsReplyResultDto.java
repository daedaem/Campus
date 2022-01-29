package com.ssafy.project.dto;

import java.util.List;

import lombok.Data;

@Data
public class SnsReplyResultDto {
    private int result;
    private int count;
    private List<SnsReplyDto> list;
}
