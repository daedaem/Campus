package com.ssafy.project.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "snsImageUrl")
public class SnsImageDto {
    private int snsImageNo;
    private int snsNo;
    private String snsImageName;
    private long snsImageSize;
    private String snsImageContentType;
    private String snsImageUrl;
    private LocalDateTime regDt;
}
