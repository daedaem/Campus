package com.ssafy.project.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SnsImageDto {
    private int snsImageNo;
    private int snsNo;
    private String snsImageName;
    private long snsImageSize;
    private String snsImageContentType;
    private String snsImageUrl;
    private LocalDateTime regDt;
}
