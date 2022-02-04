package com.ssafy.project.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.ssafy.project.dto.LikeDto;
import com.ssafy.project.dto.SnsDto;
import com.ssafy.project.dto.SnsParamDto;
import com.ssafy.project.dto.SnsReplyDto;
import com.ssafy.project.dto.SnsReplyResultDto;
import com.ssafy.project.dto.SnsResultDto;
import com.ssafy.project.dto.UserDto;
import com.ssafy.project.service.LikeService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
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

    @Autowired
    LikeService likeService;

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    
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
    // sns 글 등록
    @PostMapping(value="/sns/create")
    private ResponseEntity<SnsResultDto> snsInsert(@RequestBody SnsDto snsDto){

        // HttpSession session = request.getSession();

        // UserDto userDto = (UserDto) session.getAttribute("userDto"); // 요거는 merge 시키고 양희거 온다음
        System.out.println(snsDto);
        SnsResultDto snsResultDto = snsService.snsInsert(snsDto);

        if( snsResultDto.getResult() == SUCCESS ){
            System.out.println("snsInsert SUCCESS!");
            return new ResponseEntity<SnsResultDto>(snsResultDto, HttpStatus.OK);// 성공
        }else{
            return new ResponseEntity<SnsResultDto>(snsResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }

    @PostMapping(value="/sns/create/{snsNo}")
    private ResponseEntity<SnsResultDto> snsImageInsert(@PathVariable int snsNo, @RequestParam("fileName") List<MultipartFile> multipartFile){

        // HttpSession session = request.getSession();

        // UserDto userDto = (UserDto) session.getAttribute("userDto"); // 요거는 merge 시키고 양희거 온다음
        System.out.println(snsNo);
        SnsResultDto snsResultDto = snsService.snsImageInsert(snsNo, multipartFile);

        if( snsResultDto.getResult() == SUCCESS ){
            System.out.println("snsInsert SUCCESS!");
            return new ResponseEntity<SnsResultDto>(snsResultDto, HttpStatus.OK);// 성공
        }else{
            return new ResponseEntity<SnsResultDto>(snsResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }
    // 글 수정
    @PostMapping(value="/sns/{snsNo}")
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
    // sns글 삭제
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
    // sns detail
    @GetMapping(value="/sns/{snsNo}")
    private ResponseEntity<SnsResultDto> snsDetail(@PathVariable int snsNo, HttpSession session) throws Exception{
        
        SnsParamDto snsParamDto = new SnsParamDto();
        snsParamDto.setSnsNo(snsNo);
        //snsParamDto.setUserNo( ((UserDto) session.getAttribute("userDto")).getUserNo());

        SnsResultDto snsResultDto = snsService.snsDetail(snsParamDto);

        if( snsResultDto.getResult() == SUCCESS ){
            return new ResponseEntity<SnsResultDto>(snsResultDto, HttpStatus.OK);// 성공
        }else{
            return new ResponseEntity<SnsResultDto>(snsResultDto, HttpStatus.INTERNAL_SERVER_ERROR); // 에러
        }
    }

    // sns 댓글 리스트 생성
    @GetMapping(value="/sns/reply/{snsNo}")
    public ResponseEntity<SnsReplyResultDto> snsReplyList(@PathVariable int snsNo){
        
        SnsReplyResultDto snsReplyResultDto = snsReplyService.snsReplyList(snsNo);

        if(snsReplyResultDto.getResult() == SUCCESS){
            return new ResponseEntity<SnsReplyResultDto>(snsReplyResultDto, HttpStatus.OK);// 성공
        }else{
            return new ResponseEntity<SnsReplyResultDto>(snsReplyResultDto, HttpStatus.INTERNAL_SERVER_ERROR);// 에러
        }
    }
    
    //sns 댓글 입력
    @PostMapping(value="/sns/reply")
    public ResponseEntity<SnsReplyResultDto> snsReplyInsert(@RequestBody SnsReplyDto snsReplyDto, HttpSession session){
        
        UserDto userDto = (UserDto) session.getAttribute("userDto");

        //snsReplyDto.setUserNo(userDto.getUserNo());
        snsReplyDto.setUserNo(19);

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
        
        UserDto userDto = (UserDto) session.getAttribute("userDto");

        snsReplyDto.setUserNo(userDto.getUserNo());

        SnsReplyResultDto snsReplyResultDto = snsReplyService.snsReplyUpdate(snsReplyDto);

        if(snsReplyResultDto.getResult() == SUCCESS){
            return new ResponseEntity<SnsReplyResultDto>(snsReplyResultDto, HttpStatus.OK);// 성공
        }else{
            return new ResponseEntity<SnsReplyResultDto>(snsReplyResultDto, HttpStatus.INTERNAL_SERVER_ERROR);// 에러
        }

    }
    // 댓글 삭제
    @DeleteMapping(value="/sns/reply/{snsReplyNo}")
    public ResponseEntity<SnsReplyResultDto> snsReplyDelete(@PathVariable int snsReplyNo){
        
        SnsReplyResultDto snsReplyResultDto = snsReplyService.snsReplyDelete(snsReplyNo);

        if(snsReplyResultDto.getResult() == SUCCESS){
            return new ResponseEntity<SnsReplyResultDto>(snsReplyResultDto, HttpStatus.OK);// 성공
        }else{
            return new ResponseEntity<SnsReplyResultDto>(snsReplyResultDto, HttpStatus.INTERNAL_SERVER_ERROR);// 에러
        }

    }

    // 좋아요 입력
    @PostMapping(value = "/sns/like/{snsNo}/{userNo}")
    public ResponseEntity<Integer> likeInsert(@PathVariable int snsNo, @PathVariable int userNo) {

        if(likeService.likeInsert(snsNo, userNo) == SUCCESS){
            return new ResponseEntity<Integer>(SUCCESS, HttpStatus.OK);
        }else{
            return new ResponseEntity<Integer>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 좋아요 삭제
    @DeleteMapping(value = "/sns/like/{snsNo}/{userNo}")
    public ResponseEntity<Integer> likeDelete(@PathVariable int snsNo,@PathVariable int userNo){
        if(likeService.likeDelete(snsNo, userNo) == SUCCESS){
            return new ResponseEntity<Integer>(SUCCESS, HttpStatus.OK);
        }else{
            return new ResponseEntity<Integer>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // 좋아요 리스트 -> 글 목록에서 좋아요 확인용
    @GetMapping(value = "/sns/like/{userNo}")
    public ResponseEntity<LikeDto> likeList(@PathVariable int userNo){
        LikeDto like = new LikeDto();
        like.setLike(likeService.likeList(userNo));
        return new ResponseEntity<LikeDto>(like, HttpStatus.OK);
    }

    // 좋아요 수 표현
    @GetMapping(value = "/sns/likecount/{snsNo}")
    public ResponseEntity<LikeDto> likeCount(@PathVariable int snsNo) {
        LikeDto like = new LikeDto();
        like.setLikeCount(likeService.likeCount(snsNo));
        return new ResponseEntity<LikeDto>(like, HttpStatus.OK);
    }
    

}
