package com.ssafy.project.controller;

import com.ssafy.project.dto.MateDto;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@CrossOrigin(
		origins = "http://localhost:5500",
		allowCredentials = "true",
		allowedHeaders = "*",
		methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
				RequestMethod.HEAD, RequestMethod.OPTIONS}
		)

@RestController
public class MateController {
    
    @Autowired
    MateService service;

    private static final int SUCCESS = 1;

    @GetMapping(value="/mate")
    private ResponseEntity<MateResultDto> mateList(MateParamDto mateParamDto){
        
        MateResultDto mateResultDto;

        //call mateList from MateService
        mateResultDto = service.mateList(mateParamDto);
        System.out.println(mateResultDto.toString());

        if( mateResultDto.getResult() == SUCCESS ){
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.OK);// 성공
        }else{
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }

    }

    @PostMapping(value="/mate")
    private ResponseEntity<MateResultDto> mateInsert(MateDto mateDto, MultipartHttpServletRequest request){
        
        //로그인 했을시 session 처리 작성해주기
        //미작성

        //call mateInsert from MateService 
        MateResultDto mateResultDto = service.mateInsert(mateDto, request);

        if( mateResultDto.getResult() == SUCCESS ){
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.OK);// 성공
        }else{
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }

    @DeleteMapping(value="/mate/{mateNo}")
    private ResponseEntity<MateResultDto> mateDelete(@PathVariable(value="mateNo") int mateNo){

        //call mateDelete from MateService
        MateResultDto mateResultDto = service.mateDelete(mateNo);

        if( mateResultDto.getResult() == SUCCESS ){
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.OK);// 성공
        }else{
            return new ResponseEntity<MateResultDto>(mateResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }
    
}
