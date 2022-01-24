package com.ssafy.project.controller;


import com.ssafy.project.dto.SnsDto;
import com.ssafy.project.dto.SnsParamDto;
import com.ssafy.project.dto.SnsResultDto;
import com.ssafy.project.service.SnsService;

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
public class SnsController {
    
    @Autowired
    SnsService service;

    private static final int SUCCESS = 1;

    
    // 리스트 생성
    @GetMapping(value="/sns")
    private ResponseEntity<SnsResultDto> snsList(SnsParamDto snsParamDto){
        
        SnsResultDto snsResultDto;
        System.out.println(snsParamDto.toString());
        System.out.println("test!!");

        if( snsParamDto.getSearchWord() == null ){ // 검색어가 없을시
            System.out.println("!!!");
            snsResultDto = service.snsList(snsParamDto);
        }else{
            System.out.println("???");
            snsResultDto = service.snsListSearchWord(snsParamDto);// 검색어가 있을시에
        }

        if( snsResultDto.getResult() == SUCCESS ){
            return new ResponseEntity<SnsResultDto>(snsResultDto, HttpStatus.OK);// 성공
        }else{
            return new ResponseEntity<SnsResultDto>(snsResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }

    @PostMapping(value="/sns") // 등록
    private ResponseEntity<SnsResultDto> snsInsert(SnsDto snsDto, MultipartHttpServletRequest request){

        //HttpSession session = request.getSession();

        //UserDto userDto = (UserDto) session.getAttribute("userDto"); // 요거는 merge 시키고 양희거 온다음

        SnsResultDto snsResultDto = service.snsInsert(snsDto, request);

        if( snsResultDto.getResult() == SUCCESS ){
            return new ResponseEntity<SnsResultDto>(snsResultDto, HttpStatus.OK);// 성공
        }else{
            return new ResponseEntity<SnsResultDto>(snsResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }

    @PostMapping(value="/sns/{snsNo}") // 수정
    private ResponseEntity<SnsResultDto> snsUpdate(SnsDto snsDto, MultipartHttpServletRequest request){

        //HttpSession session = request.getSession();

        //UserDto userDto = (UserDto) session.getAttribute("userDto"); // 요거는 merge 시키고 양희거 온다음

        SnsResultDto snsResultDto = service.snsUpdate(snsDto, request);

        if( snsResultDto.getResult() == SUCCESS ){
            return new ResponseEntity<SnsResultDto>(snsResultDto, HttpStatus.OK);// 성공
        }else{
            return new ResponseEntity<SnsResultDto>(snsResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }

    @DeleteMapping(value="/sns/{snsNo}")
    private ResponseEntity<SnsResultDto> snsDelete(@PathVariable(value="snsNo") int snsNo){
        SnsResultDto snsResultDto = service.snsDelete(snsNo);
        System.out.println("delete");
        if( snsResultDto.getResult() == SUCCESS ){
            System.out.println("delete");
            return new ResponseEntity<SnsResultDto>(snsResultDto, HttpStatus.OK);// 성공
        }else{
            return new ResponseEntity<SnsResultDto>(snsResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }


}
