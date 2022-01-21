package com.ssafy.project.dto;

import lombok.Data;

@Data
public class CampSiteParamDto {
    private int limit;
    private int offset;
    private String searchWord;
    private String doNm;
    private String sigunguNm;
    private int toiletCo; // 화장실 - INT
    private int swrmCo; // 샤워실 - INT
    private int wtrplCo; // 개수대 - INT
    private char trlerAcmpnyAt; // 개인 트레일러 - ENUM('Y', 'N')
    private char caravAcmpnyAt; // 개인 카라반 - ENUM('Y', 'N')
    private String animalCmgCl; // 반려견 동반 - VARCHAR(100)
    private char exprnProgrmAt; // 체험프로그램 - ENUM('Y', 'N')
    private char clturEventAt; // 자체 문화 행사 - ENUM('Y', 'N')
    private String eqpmnLendCl; // 캠핑 장비 대여 - VARCHAR(100)
    private int siteMgCo; // 사이트 주차 - INT
}
