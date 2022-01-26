package com.ssafy.project.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SnsReplyDto {
    private int snsReplyNo;
    private int snsNo;
    private int userNo;
    private String userNickname;
    private String snsReplyContent;
    private String userProfileImage;

    private LocalDateTime snsReplyCreateTime;
    private LocalDateTime snsReplyUpdateTime;

    
}
// 컨트롤러에서 sns와 댓글 따로 부르기