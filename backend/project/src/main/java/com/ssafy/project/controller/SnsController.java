package com.ssafy.project.controller;


import javax.servlet.http.HttpSession;

import com.ssafy.project.dto.SnsDto;
import com.ssafy.project.dto.SnsParamDto;
import com.ssafy.project.dto.SnsReplyDto;
import com.ssafy.project.dto.SnsReplyResultDto;
import com.ssafy.project.dto.SnsResultDto;
import com.ssafy.project.service.SnsReplyService;
import com.ssafy.project.service.SnsService;

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
    SnsService snsService;

    @Autowired
    SnsReplyService snsReplyService;

    private static final int SUCCESS = 1;

    
    // 리스트 생성
    @GetMapping(value="/sns")
    private ResponseEntity<SnsResultDto> snsList(SnsParamDto snsParamDto){
        
        SnsResultDto snsResultDto;

        if( snsParamDto.getSearchWord() == null ){ // 검색어가 없을시
            snsResultDto = snsService.snsList(snsParamDto);
        }else{
            snsResultDto = snsService.snsListSearchWord(snsParamDto);// 검색어가 있을시에
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

        SnsResultDto snsResultDto = snsService.snsInsert(snsDto, request);

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

        SnsResultDto snsResultDto = snsService.snsUpdate(snsDto, request);

        if( snsResultDto.getResult() == SUCCESS ){
            return new ResponseEntity<SnsResultDto>(snsResultDto, HttpStatus.OK);// 성공
        }else{
            return new ResponseEntity<SnsResultDto>(snsResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }

    @DeleteMapping(value="/sns/{snsNo}")
    private ResponseEntity<SnsResultDto> snsDelete(@PathVariable(value="snsNo") int snsNo){
        SnsResultDto snsResultDto = snsService.snsDelete(snsNo);
        System.out.println("delete");
        if( snsResultDto.getResult() == SUCCESS ){
            System.out.println("delete");
            return new ResponseEntity<SnsResultDto>(snsResultDto, HttpStatus.OK);// 성공
        }else{
            return new ResponseEntity<SnsResultDto>(snsResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }
    // sns 댓글 리스트 생성
    @GetMapping(value="/sns/reply/{snsNo}")
    public ResponseEntity<SnsReplyResultDto> snsReplyList(@PathVariable int snsReplyNo){
        
        SnsReplyResultDto snsReplyResultDto = snsReplyService.snsReplyList(snsReplyNo);

        if(snsReplyResultDto.getResult() == SUCCESS){
            return new ResponseEntity<SnsReplyResultDto>(snsReplyResultDto, HttpStatus.OK);// 성공
        }else{
            return new ResponseEntity<SnsReplyResultDto>(snsReplyResultDto, HttpStatus.INTERNAL_SERVER_ERROR);// 에러
        }

    }
    // sns 댓글 입력
    @PostMapping(value="/sns/reply")
    public ResponseEntity<SnsReplyResultDto> snsReplyInsert(@RequestBody SnsReplyDto snsReplyDto, HttpSession session){
        
        //UserDto userDto = (UserDto) session.getAttribute("userDto");

        snsReplyDto.setUserNo(userDto.getUserNo());

        SnsReplyResultDto snsReplyResultDto = snsReplyService.snsReplyInsert(snsReplyDto);

        if(snsReplyResultDto.getResult() == SUCCESS){
            return new ResponseEntity<SnsReplyResultDto>(snsReplyResultDto, HttpStatus.OK);// 성공
        }else{
            return new ResponseEntity<SnsReplyResultDto>(snsReplyResultDto, HttpStatus.INTERNAL_SERVER_ERROR);// 에러
        }

    }
    // sns 댓글 수정
    @PutMapping(value="/sns/reply")
    public ResponseEntity<SnsReplyResultDto> snsReplyUpdate(@RequestBody SnsReplyDto snsReplyDto, HttpSession session){
        
        //UserDto userDto = (UserDto) session.getAttribute("userDto");

        snsReplyDto.setUserNo(userDto.getUserNo());

        SnsReplyResultDto snsReplyResultDto = snsReplyService.snsReplyUpdate(snsReplyDto);

        if(snsReplyResultDto.getResult() == SUCCESS){
            return new ResponseEntity<SnsReplyResultDto>(snsReplyResultDto, HttpStatus.OK);// 성공
        }else{
            return new ResponseEntity<SnsReplyResultDto>(snsReplyResultDto, HttpStatus.INTERNAL_SERVER_ERROR);// 에러
        }

    }

    @DeleteMapping(value="/sns/reply/{snsReplyNo}")
    public ResponseEntity<SnsReplyResultDto> snsReplyDelete(@PathVariable(value="snsNo") int snsReplyNo){
        
        SnsReplyResultDto snsReplyResultDto = snsReplyService.SnsReplyDelete(snsReplyNo);

        if(snsReplyResultDto.getResult() == SUCCESS){
            return new ResponseEntity<SnsReplyResultDto>(snsReplyResultDto, HttpStatus.OK);// 성공
        }else{
            return new ResponseEntity<SnsReplyResultDto>(snsReplyResultDto, HttpStatus.INTERNAL_SERVER_ERROR);// 에러
        }

    }

}
