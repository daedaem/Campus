package com.ssafy.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocketDto {
        // 유저의 이름을 저장하기 위한 변수
        private String userName;

        // 메시지의 내용을 저장하기 위한 변수
        private String content;
}
