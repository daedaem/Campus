package com.ssafy.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ssafy.project.dto.CampRateDto;
import com.ssafy.project.dto.CampRateReplyDto;
import com.ssafy.project.dto.CampRateReplyResultDto;
import com.ssafy.project.dto.CampRateResultDto;
import com.ssafy.project.dto.CampSiteDto;
import com.ssafy.project.dto.CampSiteParamDto;
import com.ssafy.project.dto.CampSiteResultDto;
import com.ssafy.project.dto.FollowDto;
import com.ssafy.project.dto.UserDto;
import com.ssafy.project.service.CampRateReplyService;
import com.ssafy.project.service.CampRateService;
import com.ssafy.project.service.CampSiteService;
import com.ssafy.project.service.FollowService;

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

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    // 캠핑장 리스트
    @GetMapping(value = "/camp")
    public ResponseEntity<CampSiteResultDto> campList(CampSiteParamDto campSiteParamDto) {

        CampSiteResultDto campSiteResultDto;

        if (!campSiteParamDto.getSearchWord().isEmpty() || !campSiteParamDto.getDoNm().isEmpty()) {
            campSiteResultDto = campSiteService.campSiteSearch(campSiteParamDto);
        } else {
            campSiteResultDto = campSiteService.campSiteList(campSiteParamDto);
        }

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

        campRateDto.setUserNo(userDto.getUserNo());

        CampRateResultDto campRateResultDto = campRateService.campRateInsert(campRateDto);

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
