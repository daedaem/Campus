package com.ssafy.project.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SnsReplyDto {
    private int snsReplyNo;
    private int snsNo;
    private int userNo;
    private String userNickname;
    private String snsReplyContent;
    private String userProfileImage;
    private String userEmail;

    private LocalDateTime snsReplyCreateTime;
    private LocalDateTime snsReplyUpdateTime;

    
}
// 컨트롤러에서 sns와 댓글 따로 부르기