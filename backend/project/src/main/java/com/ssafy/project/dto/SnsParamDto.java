package com.ssafy.project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SnsParamDto {
    private String searchWord;

    private int snsNo;
    private int userNo;
}
