package com.ssafy.project.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SnsParamDto {
    private int limit;
    private int offset;
    private String searchWord;
    private int snsNo;
    private int userNo;
    private List<Integer> followingList;
    
}//