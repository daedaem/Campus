package com.ssafy.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampSiteDto {
    private String contentId; // 콘텐츠 ID
    private String addr1; // 주소
    private String facltNm; // 야영장명
    private String sigunguNm; // 시군구
    private String doNm; // 도
    private String lineIntro; // 한줄소개
    private String intro; // 소개
    private int allar; // 전체면적
    private String lctCl; // 입지구분
    private double mapY; // 위도(Y)
    private double mapX; // 경도(X)
    private String tel; // 전화
    private String resveUrl; // 예약 페이지
    private String resveCl; // 예약구분
    private int gnrlSiteCo; // 주요시설 일반야영장
    private int autoSiteCo; // 주요시설 자동차야영장
    private int glampSiteCo; // 주요시설 글램핑
    private int caravSiteCo; // 주요시설 카라반
    private int indvdlCaravSiteCo; // 주요시설 개인 카라반
    private int siteBottomCl1; // 잔디
    private int siteBottomCl2; // 파쇄석
    private int siteBottomCl3; // 테크
    private int siteBottomCl4; // 자갈
    private int siteBottomCl5; // 맨흙
    private String tooltip; // 툴팁
    private String glampInnerFclty; // 글램핑-내부시설
    private String caravInnerFclty; // 카라반-내부시설
    private String operPdCl; // 운영기간
    private String operDeCl; // 운영일
    private char trlerAcmpnyAt; // 개인 트레일러 동반 여부
    private char caravAcmpnyAt; // 개인 카라반 동반 여부
    private int toiletCo; // 화장실 개수
    private int swrmCo; // 샤워실 개수
    private int wtrplCo; // 개수대 개수
    private String brazierCl; // 화로대
    private String sbrsCl; // 부대시설
    private String sbrsEtc; // 부대시설 기타
    private String posblFcltyCl; // 주변이용가능시설
    private String posblFcltyEtc; // 주변이용가능시설 기타
    private char clturEventAt; // 자체문화행사 여부
    private String clturEvent; // 자체문화행사명
    private char exprnProgrmAt; // 체험프로그램 여부
    private String exprnProgrm; // 체험프로그램명
    private int extshrCo; // 소화기 개수
    private int frprvtWrppCo; // 방화수 개수
    private int frprvtSandCo; // 방화사 개수
    private int fireSensorCo; // 화재감지기 개수
    private String themaEnvrnCl; // 테마환경
    private String eqpmnLendCl; // 캠핑장비대여
    private String animalCmgCl; // 애완동물출입
    private String tourEraCl; // 여행시기
    private String firstImageUrl; // 대표이미지
    private String createdtime; // 등록일
    private String modifiedtime; // 수정일
    private int sitedStnc; // 사이트간 거리
    private int siteMg1Width; // 사이트 크기 1 가로
    private int siteMg2Width; // 사이트 크기 2 가로
    private int siteMg3Width; // 사이트 크기 3 가로
    private int siteMg1Vrticl; // 사이트 크기 1 세로
    private int siteMg2Vrticl; // 사이트 크기 2 세로
    private int siteMg3Vrticl; // 사이트 크기 3 세로
    private int siteMg1Co; // 사이트 크기 1 수량
    private int siteMg2Co; // 사이트 크기 2 수량
    private int siteMg3Co; // 사이트 크기 3 수량
    private int siteMgCo;
}
