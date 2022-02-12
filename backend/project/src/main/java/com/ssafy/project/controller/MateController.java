package com.ssafy.project.controller;

import javax.servlet.http.HttpSession;

import com.ssafy.project.dto.MateDto;
import com.ssafy.project.dto.MateListDto;
import com.ssafy.project.dto.MateMatchResultDto;
import com.ssafy.project.dto.MateParamDto;
import com.ssafy.project.dto.MateResultDto;
import com.ssafy.project.dto.UserDto;
import com.ssafy.project.service.MateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:5500", allowCredentials = "true", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
        RequestMethod.HEAD, RequestMethod.OPTIONS })

@RestController
public class MateController {

    @Autowired
    MateService service;

    private static final int SUCCESS = 1;

    // 메이트 리스트 띄우기
    @GetMapping(value = "/mate")
    private ResponseEntity<MateResultDto> mateList(MateParamDto mateParamDto) {

        MateResultDto mateResultDto;

        // call mateList from MateService
        mateResultDto = service.mateList(mateParamDto);

        if (mateResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.OK);// 성공
        } else {
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }

    }

    @PostMapping(value = "/mate")

    private ResponseEntity<MateResultDto> mateInsert(@RequestBody MateDto mateDto, HttpSession session) {

        // UserDto userDto = (UserDto) session.getAttribute("userDto"); // 요거는 merge 시키고 양희거 온다음
        mateDto.setContentId(10);
        mateDto.setUserNo(mateDto.getUserNo());

        MateResultDto mateResultDto = service.mateInsert(mateDto);

        if (mateResultDto.getResult() == SUCCESS) {

            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.OK);// 성공
        } else {
            return new ResponseEntity<MateResultDto>(mateResultDto,
                    HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }

    @PostMapping(value = "/mate/{mateNo}")
    private ResponseEntity<MateResultDto> mateImageInsert(@PathVariable int mateNo,
            @RequestParam("fileName") MultipartFile multipartFile) {

        // 로그인 했을시 session 처리 작성해주기
        // 미작성
        // call mateInsert from MateService

        MateResultDto mateResultDto = service.mateImageInsert(mateNo, multipartFile);

        if (mateResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.OK);// 성공
        } else {
            return new ResponseEntity<MateResultDto>(mateResultDto,
                    HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }

    @DeleteMapping(value = "/mate/{mateNo}")
    private ResponseEntity<MateResultDto> mateDelete(@PathVariable int mateNo) {

        // call mateDelete from MateService
        MateResultDto mateResultDto = service.mateDelete(mateNo);

        if (mateResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.OK);// 성공
        } else {
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }

    @PutMapping(value = "/mate")
    private ResponseEntity<MateResultDto> mateUpdate(@RequestBody MateDto mateDto) {

    //로그인 했을시 session 처리 작성해주기
    //미작성
    //call mateInsert from MateService
    mateDto.setContentId(10);
    // mateDto.setUserNo(25);

        MateResultDto mateResultDto = service.mateUpdate(mateDto);

        if (mateResultDto.getResult() == SUCCESS) {

            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.OK);// 성공
        } else {
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }

    @PutMapping(value = "/mate/image/{mateNo}")
    private ResponseEntity<MateResultDto> mateImageUpdate(@PathVariable int mateNo,
            @RequestParam("fileName") MultipartFile multipartFile) {

        // 로그인 했을시 session 처리 작성해주기
        // 미작성
        // call mateInsert from MateService

        MateResultDto mateResultDto = service.mateImageUpdate(mateNo, multipartFile);

        if (mateResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.OK);// 성공
        } else {
            return new ResponseEntity<MateResultDto>(mateResultDto,
                    HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }

    @PutMapping(value = "/mate/imagenull/{mateNo}")
    private ResponseEntity<MateResultDto> mateImageUpdateNull(@PathVariable int mateNo) {

        // 로그인 했을시 session 처리 작성해주기
        // 미작성
        // call mateInsert from MateService

        MateResultDto mateResultDto = service.mateImageUpdateNull(mateNo);

        if (mateResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.OK);// 성공
        } else {
            return new ResponseEntity<MateResultDto>(mateResultDto,
                    HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }

    @GetMapping(value = "/mate/{mateNo}")
    private ResponseEntity<MateResultDto> mateDetail(@PathVariable int mateNo) {

        MateResultDto mateResultDto;

        // call mateList from MateService
        mateResultDto = service.mateDetail(mateNo);
        System.out.println(mateResultDto.toString());

        if (mateResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.OK);// 성공
        } else {
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }

    }

    @PostMapping(value = "/mate/apply")
    private ResponseEntity<MateResultDto> mateApplyInsert(@RequestBody MateListDto matelistDto) {

    //로그인 했을시 session 처리 작성해주기
    //미작성
    //call mateInsert from MateService
    // matelistDto.setMateNo(56);
   

        MateResultDto mateResultDto = service.mateListInsert(matelistDto);

        if (mateResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.OK);// 성공
        } else {
            return new ResponseEntity<MateResultDto>(mateResultDto,
                    HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }

    @DeleteMapping(value = "/mate/apply/{mateListNo}")
    private ResponseEntity<MateResultDto> mateApplyDelete(@PathVariable int mateListNo) {

        // call mateDelete from MateService
        MateResultDto mateResultDto = service.mateApplyDelete(mateListNo);

        if (mateResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.OK);// 성공
        } else {
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }

    @GetMapping(value = "/mate/match/{userNo}")
    private ResponseEntity<MateMatchResultDto> mateMatch(@PathVariable int userNo) {

        MateMatchResultDto mateMatchResultDto;

        // call mateList from MateService
        mateMatchResultDto = service.mateMatch(userNo);

        if (mateMatchResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<MateMatchResultDto>(mateMatchResultDto, HttpStatus.OK);// 성공
        } else {
            return new ResponseEntity<MateMatchResultDto>(mateMatchResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }

    }

    // 메인 페이지에 메이트 5개 띄우기
    @GetMapping(value = "/mate/main")
    private ResponseEntity<MateResultDto> mateListMain(MateParamDto mateParamDto) {
        
        MateResultDto mateResultDto;

        // call mateList from MateService
        mateResultDto = service.mateListMain(mateParamDto);

        if (mateResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.OK);// 성공
        } else {
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }

    }

    @PutMapping(value = "/mate/detail/status/{mateNo}")
    private ResponseEntity<MateResultDto> mateStatusUpdate(@PathVariable int mateNo) {
        
        MateResultDto mateResultDto = service.mateStatusUpdate(mateNo);

        if (mateResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.OK);// 성공
        } else {
            return new ResponseEntity<MateResultDto>(mateResultDto,
                    HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }

    // ----------------------------------------- 필터링 -----------------------------------------//
    //캠핑장 유형 필터링
    @PostMapping(value = "/mate/filter")
    private ResponseEntity<MateResultDto> mateFilter(@RequestBody MateDto mateDto) {


        MateResultDto mateResultDto = service.mateFilter(mateDto);

        if (mateResultDto.getResult() == SUCCESS) {

            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.OK);// 성공
        } else {
            return new ResponseEntity<MateResultDto>(mateResultDto,
                    HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }

}