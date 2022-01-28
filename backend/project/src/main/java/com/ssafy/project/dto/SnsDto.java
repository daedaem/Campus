package com.ssafy.project.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class SnsDto {
    private int snsNo;
    private int userNo;
    private String userNickname;
    private String snsContent;

    private LocalDateTime snsCreateTime;
    private LocalDateTime snsUpdateTime;

    private String userProfileImageUrl;

    private List<SnsImageDto> ImageList;
}
