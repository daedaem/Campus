package com.ssafy.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MateListDto {
    private int mateNo;
    private int userNo;
    private int mateListNo;
    private int mateListAge;
    private int mateListNum;
    private String mateGender;
}
