package com.ssafy.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SnsParamDto {
    private String searchWord;
    private int snsNo;
    private int userNo;

}
