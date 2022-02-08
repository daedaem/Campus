package com.ssafy.project.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.ssafy.project.dto.CampRateDto;
import com.ssafy.project.dto.CampRateReplyDto;
import com.ssafy.project.dto.CampRateReplyResultDto;
import com.ssafy.project.dto.CampRateResultDto;
import com.ssafy.project.dto.CampSiteInfoDto;
import com.ssafy.project.dto.CampSiteInfoDtoRepository;
import com.ssafy.project.dto.CampSiteParamDto;
import com.ssafy.project.dto.CampSiteResultDto;
import com.ssafy.project.dto.UserDto;
import com.ssafy.project.service.CampRateReplyService;
import com.ssafy.project.service.CampRateService;
import com.ssafy.project.service.CampSiteService;

@CrossOrigin(origins = "http://localhost:5500", allowCredentials = "true", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.OPTIONS })
@RestController // 값자체를 리턴
public class CampController {

    @Autowired
    CampSiteService campSiteService;

    @Autowired
    CampRateService campRateService;

    @Autowired
    CampRateReplyService campRateReplyService;

    @Autowired
    CampSiteInfoDtoRepository campSiteInfoDtoRepository;

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    // 캠핑장 리스트
    @GetMapping(value = "/camp")
    public ResponseEntity<CampSiteResultDto> campList(CampSiteParamDto campSiteParamDto) {

        CampSiteResultDto campSiteResultDto;
        System.out.println(campSiteParamDto);

        if (campSiteParamDto.getSearchWord() != null || campSiteParamDto.getDoNm() != null) {
            if (campSiteParamDto.getEqpmnLendCl().equals("Y")) {
                campSiteResultDto = campSiteService.campSiteSearch(campSiteParamDto);
            } else {
                campSiteResultDto = campSiteService.campSiteSearchNull(campSiteParamDto);
            }
        } else {
            campSiteResultDto = campSiteService.campSiteList(campSiteParamDto);
        }

        if (campSiteResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<CampSiteResultDto>(campSiteResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<CampSiteResultDto>(campSiteResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 공공데이터 DB에 저장
    @PostMapping(value = "/camp")
    public CampSiteResultDto saveCampSiteInfo(Model model) {
        CampSiteResultDto campSiteResultDto = new CampSiteResultDto();
        String result = "";

        try {
            URL url = new URL(
                    "http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/basedList?ServiceKey=2uNi5%2Flq4H42uj22b9DRQh49za8yK7yTMO2HDn0S%2F5KhePX1dGAnTDlC96pDnmB4yStD69N49HeAjpeBOyVMGw%3D%3D&numOfRows=2906&pageNo=1&MobileOS=ETC&MobileApp=TestApp&_type=json");
            BufferedReader bf;
            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            result = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
            JSONObject response = (JSONObject) jsonObject.get("response");
            // JSONObject header = (JSONObject) jsonObject.get("header");
            // Long totalCount = (Long) response.get("totalCount");

            JSONObject body = (JSONObject) response.get("body");
            JSONObject items = (JSONObject) body.get("items");
            JSONArray infoArr = (JSONArray) items.get("item");

            for (int i = 0; i < infoArr.size(); i++) {
                JSONObject tmp = (JSONObject) infoArr.get(i);
                String contentId = String.valueOf(tmp.get("contentId")); // 콘텐츠 ID
                String addr1 = (String) tmp.get("addr1"); // 주소
                String facltNm = (String) tmp.get("facltNm"); // 야영장명
                String sigunguNm = (String) tmp.get("sigunguNm"); // 시군구
                String doNm = (String) tmp.get("doNm"); // 도
                String lineIntro = (String) tmp.get("lineIntro"); // 한줄소개
                String intro = (String) tmp.get("intro"); // 소개
                int allar = Integer.parseInt(String.valueOf(tmp.get("allar"))); // 전체면적
                String lctCl = (String) tmp.get("lctCl"); // 입지구분
                double mapY = Double.parseDouble(String.valueOf(tmp.get("mapY"))); // 위도(Y)
                double mapX = Double.parseDouble(String.valueOf(tmp.get("mapX"))); // 경도(X)
                String tel = (String) tmp.get("tel"); // 전화
                String resveUrl = (String) tmp.get("resveUrl"); // 예약 페이지
                String resveCl = (String) tmp.get("resveCl"); // 예약구분
                int gnrlSiteCo = Integer.parseInt(String.valueOf(tmp.get("gnrlSiteCo"))); // 주요시설 일반야영장
                int autoSiteCo = Integer.parseInt(String.valueOf(tmp.get("autoSiteCo"))); // 주요시설 자동차야영장
                int glampSiteCo = Integer.parseInt(String.valueOf(tmp.get("glampSiteCo"))); // 주요시설 글램핑
                int caravSiteCo = Integer.parseInt(String.valueOf(tmp.get("caravSiteCo"))); // 주요시설 카라반
                int indvdlCaravSiteCo = Integer.parseInt(String.valueOf(tmp.get("indvdlCaravSiteCo"))); // 주요시설 개인 카라반
                int siteBottomCl1 = Integer.parseInt(String.valueOf(tmp.get("siteBottomCl1"))); // 잔디
                int siteBottomCl2 = Integer.parseInt(String.valueOf(tmp.get("siteBottomCl2"))); // 파쇄석
                int siteBottomCl3 = Integer.parseInt(String.valueOf(tmp.get("siteBottomCl3"))); // 테크
                int siteBottomCl4 = Integer.parseInt(String.valueOf(tmp.get("siteBottomCl4"))); // 자갈
                int siteBottomCl5 = Integer.parseInt(String.valueOf(tmp.get("siteBottomCl5"))); // 맨흙
                String tooltip = (String) tmp.get("tooltip"); // 툴팁
                String glampInnerFclty = (String) tmp.get("glampInnerFclty"); // 글램핑-내부시설
                String caravInnerFclty = (String) tmp.get("caravInnerFclty"); // 카라반-내부시설
                String operPdCl = (String) tmp.get("operPdCl"); // 운영기간
                String operDeCl = (String) tmp.get("operDeCl"); // 운영일
                char trlerAcmpnyAt = ((String) tmp.get("trlerAcmpnyAt")).charAt(0); // 개인 트레일러 동반 여부
                char caravAcmpnyAt = ((String) tmp.get("caravAcmpnyAt")).charAt(0); // 개인 카라반 동반 여부
                int toiletCo = Integer.parseInt(String.valueOf(tmp.get("toiletCo"))); // 화장실 개수
                int swrmCo = Integer.parseInt(String.valueOf(tmp.get("swrmCo"))); // 샤워실 개수
                int wtrplCo = Integer.parseInt(String.valueOf(tmp.get("wtrplCo"))); // 개수대 개수
                String brazierCl = String.valueOf(tmp.get("brazierCo")); // 화로대
                String sbrsCl = (String) tmp.get("sbrsCl"); // 부대시설
                String sbrsEtc = (String) tmp.get("sbrsEtc"); // 부대시설 기타
                String posblFcltyCl = (String) tmp.get("posblFcltyCl"); // 주변이용가능시설
                String posblFcltyEtc = (String) tmp.get("posblFcltyEtc"); // 주변이용가능시설 기타
                char clturEventAt = ((String) tmp.get("clturEventAt")).charAt(0);// 자체문화행사 여부
                String clturEvent = (String) tmp.get("clturEvent"); // 자체문화행사명
                char exprnProgrmAt = ((String) tmp.get("exprnProgrmAt")).charAt(0); // 체험프로그램 여부
                String exprnProgrm = (String) tmp.get("exprnProgrm"); // 체험프로그램명
                int extshrCo = Integer.parseInt(String.valueOf(tmp.get("extshrCo"))); // 소화기 개수
                int frprvtWrppCo = Integer.parseInt(String.valueOf(tmp.get("frprvtWrppCo"))); // 방화수 개수
                int frprvtSandCo = Integer.parseInt(String.valueOf(tmp.get("frprvtSandCo"))); // 방화사 개수
                int fireSensorCo = Integer.parseInt(String.valueOf(tmp.get("fireSensorCo"))); // 화재감지기 개수
                String themaEnvrnCl = (String) tmp.get("themaEnvrnCl"); // 테마환경
                String eqpmnLendCl = (String) tmp.get("eqpmnLendCl"); // 캠핑장비대여
                String animalCmgCl = (String) tmp.get("animalCmgCl"); // 애완동물출입
                String tourEraCl = (String) tmp.get("tourEraCl"); // 여행시기
                String firstImageUrl = (String) tmp.get("firstImageUrl"); // 대표이미지
                String createdtime = (String) tmp.get("createdTime"); // 등록일
                String modifiedtime = (String) tmp.get("modifiedTime"); // 수정일
                int sitedStnc = Integer.parseInt(String.valueOf(tmp.get("sitedStnc"))); // 사이트간 거리
                int siteMg1Width = Integer.parseInt(String.valueOf(tmp.get("siteMg1Width"))); // 사이트 크기 1 가로
                int siteMg2Width = Integer.parseInt(String.valueOf(tmp.get("siteMg2Width"))); // 사이트 크기 2 가로
                int siteMg3Width = Integer.parseInt(String.valueOf(tmp.get("siteMg3Width"))); // 사이트 크기 3 가로
                int siteMg1Vrticl = Integer.parseInt(String.valueOf(tmp.get("siteMg1Vrticl"))); // 사이트 크기 1 세로
                int siteMg2Vrticl = Integer.parseInt(String.valueOf(tmp.get("siteMg2Vrticl"))); // 사이트 크기 2 세로
                int siteMg3Vrticl = Integer.parseInt(String.valueOf(tmp.get("siteMg3Vrticl"))); // 사이트 크기 3 세로
                int siteMg1Co = Integer.parseInt(String.valueOf(tmp.get("siteMg1Co"))); // 사이트 크기 1 수량
                int siteMg2Co = Integer.parseInt(String.valueOf(tmp.get("siteMg2Co"))); // 사이트 크기 2 수량
                int siteMg3Co = Integer.parseInt(String.valueOf(tmp.get("siteMg3Co"))); // 사이트 크기 3 수량
                CampSiteInfoDto campSiteInfoDto = new CampSiteInfoDto(contentId, addr1,
                        facltNm, sigunguNm, doNm,
                        lineIntro, intro, allar, lctCl, mapY, mapX, tel, resveUrl, resveCl,
                        gnrlSiteCo, autoSiteCo,
                        glampSiteCo, caravSiteCo, indvdlCaravSiteCo, siteBottomCl1, siteBottomCl2,
                        siteBottomCl3,
                        siteBottomCl4, siteBottomCl5, tooltip, glampInnerFclty, caravInnerFclty,
                        operPdCl, operDeCl,
                        trlerAcmpnyAt, caravAcmpnyAt, toiletCo, swrmCo, wtrplCo, brazierCl, sbrsCl,
                        sbrsEtc,
                        posblFcltyCl, posblFcltyEtc, clturEventAt, clturEvent, exprnProgrmAt,
                        exprnProgrm, extshrCo,
                        frprvtWrppCo, frprvtSandCo, fireSensorCo, themaEnvrnCl, eqpmnLendCl,
                        animalCmgCl, tourEraCl,
                        firstImageUrl, createdtime, modifiedtime, sitedStnc, siteMg1Width,
                        siteMg2Width, siteMg3Width,
                        siteMg1Vrticl, siteMg2Vrticl, siteMg3Vrticl, siteMg1Co, siteMg2Co,
                        siteMg3Co);
                campSiteInfoDtoRepository.save(campSiteInfoDto);
            }
            campSiteResultDto.setResult(SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            campSiteResultDto.setResult(FAIL);
        }
        return campSiteResultDto;
    }

    // 캠핑장 detail
    @GetMapping(value = "/camp/{contentId}")
    public ResponseEntity<CampSiteResultDto> campDetail(@PathVariable String contentId) {

        CampSiteResultDto campSiteResultDto;

        campSiteResultDto = campSiteService.campSiteDetail(contentId);
        System.out.println(campSiteResultDto);
        if (campSiteResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<CampSiteResultDto>(campSiteResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<CampSiteResultDto>(campSiteResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 도 list
    @GetMapping(value = "/camp/do")
    public ResponseEntity<List<String>> getDo() {
        if (campSiteService.campSiteDo() != null) {
            return new ResponseEntity<List<String>>(campSiteService.campSiteDo(), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<String>>(campSiteService.campSiteDo(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 시군구 list
    @GetMapping(value = "/camp/sigungu/{doNm}")
    public ResponseEntity<List<String>> getSigungn(@PathVariable String doNm) {
        if (campSiteService.campSiteSigungu(doNm) != null) {
            return new ResponseEntity<List<String>>(campSiteService.campSiteSigungu(doNm), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<String>>(campSiteService.campSiteSigungu(doNm),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 캠핑장 평점 리스트
    @GetMapping(value = "/camp/rate/{contentId}")
    public ResponseEntity<CampRateResultDto> campRateList(@PathVariable String contentId) {

        CampRateResultDto campRateResultDto = campRateService.campRateList(contentId);

        if (campRateResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<CampRateResultDto>(campRateResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<CampRateResultDto>(campRateResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 캠핑장 평점 상세정보
    @GetMapping(value = "/camp/rate/{campRateNo}")
    public ResponseEntity<CampRateResultDto> campRateDetail(@PathVariable int campRateNo, HttpSession session) {

        UserDto userDto = (UserDto) session.getAttribute("userDto");
        int userNo;
        if (userDto != null)
            userNo = userDto.getUserNo();
        else
            userNo = 0;

        CampRateResultDto campRateResultDto = campRateService.campRateDetail(campRateNo, userNo);

        if (campRateResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<CampRateResultDto>(campRateResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<CampRateResultDto>(campRateResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 캠핑장 평점 추가
    @PostMapping(value = "/camp/rate")
    public ResponseEntity<CampRateResultDto> campRateInsert(@RequestBody CampRateDto campRateDto, HttpSession session) {

        UserDto userDto = (UserDto) session.getAttribute("userDto");
        System.out.println(campRateDto);
        campRateDto.setUserNo(userDto.getUserNo());

        CampRateResultDto campRateResultDto = campRateService.campRateInsert(campRateDto);
        System.out.println(campRateDto);
        if (campRateResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<CampRateResultDto>(campRateResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<CampRateResultDto>(campRateResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 캠핑장 평점 수정
    @PutMapping(value = "/camp/rate")
    public ResponseEntity<CampRateResultDto> campRateUpdate(@RequestBody CampRateDto campRateDto, HttpSession session) {

        UserDto userDto = (UserDto) session.getAttribute("userDto");

        campRateDto.setUserNo(userDto.getUserNo());

        CampRateResultDto campRateResultDto = campRateService.campRateUpdate(campRateDto);

        if (campRateResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<CampRateResultDto>(campRateResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<CampRateResultDto>(campRateResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 캠핑장 평점 삭제
    @DeleteMapping(value = "/camp/rate/{campRateNo}")
    public ResponseEntity<CampRateResultDto> campRateDelete(@PathVariable(value = "campRateNo") int campRateNo) {
        CampRateResultDto campRateResultDto = campRateService.campRateDelete(campRateNo);

        if (campRateResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<CampRateResultDto>(campRateResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<CampRateResultDto>(campRateResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 캠핑장 평점 댓글 리스트
    @GetMapping(value = "/camp/rate/reply/{campRateNo}")
    public ResponseEntity<CampRateReplyResultDto> campRateReplyList(@PathVariable int campRateNo) {

        CampRateReplyResultDto campRateReplyResultDto = campRateReplyService.campRateReplyList(campRateNo);

        if (campRateReplyResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<CampRateReplyResultDto>(campRateReplyResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<CampRateReplyResultDto>(campRateReplyResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 캠핑장 평점 댓글 추가
    @PostMapping(value = "/camp/rate/reply")
    public ResponseEntity<CampRateReplyResultDto> campRateReplyInsert(@RequestBody CampRateReplyDto campRateReplyDto,
            HttpSession session) {

        UserDto userDto = (UserDto) session.getAttribute("userDto");

        campRateReplyDto.setUserNo(userDto.getUserNo());

        CampRateReplyResultDto campRateReplyResultDto = campRateReplyService.campRateReplyInsert(campRateReplyDto);

        if (campRateReplyResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<CampRateReplyResultDto>(campRateReplyResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<CampRateReplyResultDto>(campRateReplyResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 캠핑장 평점 댓글 수정
    @PutMapping(value = "/camp/rate/reply")
    public ResponseEntity<CampRateReplyResultDto> campRateReplyUpdate(@RequestBody CampRateReplyDto campRateReplyDto,
            HttpSession session) {

        UserDto userDto = (UserDto) session.getAttribute("userDto");

        campRateReplyDto.setUserNo(userDto.getUserNo());

        CampRateReplyResultDto campRateReplyResultDto = campRateReplyService.campRateReplyUpdate(campRateReplyDto);

        if (campRateReplyResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<CampRateReplyResultDto>(campRateReplyResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<CampRateReplyResultDto>(campRateReplyResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 캠핑장 평점 댓글 삭제
    @DeleteMapping(value = "/camp/rate/reply/{campRateReplyNo}")
    public ResponseEntity<CampRateReplyResultDto> campRateReplyDelete(
            @PathVariable(value = "campRateNo") int campRateReplyNo) {
        CampRateReplyResultDto campRateReplyResultDto = campRateReplyService.campRateReplyDelete(campRateReplyNo);

        if (campRateReplyResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<CampRateReplyResultDto>(campRateReplyResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<CampRateReplyResultDto>(campRateReplyResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
