package com.ssafy.project.controller;

import com.ssafy.project.dto.MateDto;
import com.ssafy.project.dto.MateListDto;
import com.ssafy.project.dto.MateParamDto;
import com.ssafy.project.dto.MateResultDto;
import com.ssafy.project.service.MateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    //메이트 리스트 띄우기
    @GetMapping(value = "/mate")
    private ResponseEntity<MateResultDto> mateList(MateParamDto mateParamDto) {

        MateResultDto mateResultDto;

        // call mateList from MateService
        mateResultDto = service.mateList(mateParamDto);
        System.out.println(mateResultDto.toString());

        if (mateResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.OK);// 성공
        } else {
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }

    }

    @PostMapping(value="/mate")
    private ResponseEntity<MateResultDto> mateInsert( MateDto mateDto,  MultipartFile multipartFile ){
    private ResponseEntity<MateResultDto> mateInsert( MateDto mateDto){

    //로그인 했을시 session 처리 작성해주기
    //미작성
    //call mateInsert from MateService
    mateDto.setContentId(10);
    mateDto.setUserNo(3);
    System.out.println(mateDto.toString());

    MateResultDto mateResultDto = service.mateInsert(mateDto);

    if( mateResultDto.getResult() == SUCCESS ){
        return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.OK);// 성공
        }else{
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

    @PostMapping(value="/mate/apply")
    private ResponseEntity<MateResultDto> mateApplyInsert(@RequestBody MateListDto matelistDto){

    //로그인 했을시 session 처리 작성해주기
    //미작성
    //call mateInsert from MateService
    // matelistDto.setMateNo(56);
    // matelistDto.setUserNo(3);

    MateResultDto mateResultDto = service.mateListInsert(matelistDto);

    if( mateResultDto.getResult() == SUCCESS ){
        return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.OK);// 성공
        }else{
        return new ResponseEntity<MateResultDto>(mateResultDto,
        HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }

}
