package com.ssafy.project.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SnsDto {
    private int snsNo;
    private int userNo;
    private String userNickname;
    private String snsContent;

    private LocalDateTime snsCreateTime;
    private LocalDateTime snsUpdateTime;

    private String userProfileImage;

    private List<SnsImageDto> ImageList;
    private List<SnsReplyDto> ReplyList;
}
