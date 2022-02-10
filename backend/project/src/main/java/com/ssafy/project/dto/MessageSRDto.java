package com.ssafy.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageSRDto {
    private int sendId;
    private int receiveId;
}
