package com.ssafy.project.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SnsReplyDto {
    private int snsReplyNo;
    private int snsNo;
    private int userNo;
    private String snsReplyContent;

    private LocalDateTime snsReplyCreateTime;
    private LocalDateTime snsReplyUpdateTime;

    
}
