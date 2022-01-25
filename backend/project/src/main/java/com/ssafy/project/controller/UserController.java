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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.project.dto.UserDto;
import com.ssafy.project.dto.UserRateDto;
import com.ssafy.project.dto.UserResultDto;
import com.ssafy.project.service.UserService;

@CrossOrigin(origins = "http://localhost:5500", allowCredentials = "true", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.OPTIONS })
@RestController // == > @Controller + @ResponseBody ==> 여기는 다 json 으로 넘어간다!! // 값자체를 리턴
public class UserController {

    @Autowired
    UserService userService;

    private static final int SUCCESS = 1;

    // 회원가입
    @PostMapping(value = "/user")
    public ResponseEntity<UserResultDto> register(@RequestBody UserDto userDto) { // restapi를 이용해서 http 상태코드를 성공 실패여부로
                                                                                  // 같이 넘겨준다.
        UserResultDto userResultDto = userService.userRegister(userDto);
        if (userResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // userEmail에 해당하는 user 정보 구하기
    @GetMapping(value = "/user/{userEmail}")
    public ResponseEntity<UserDto> select(@PathVariable String userEmail) { // restapi를 이용해서 http 상태코드를 성공 실패여부로 같이
                                                                            // 넘겨준다.
        UserDto userDto = userService.userSelect(userEmail);
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }

    // user 정보 업데이트
    @PutMapping(value = "/user")
    public ResponseEntity<UserResultDto> update(@RequestBody UserDto userDto) { // restapi를 이용해서 http 상태코드를 성공 실패여부로 같이
                                                                                // 넘겨준다.
        UserResultDto userResultDto = userService.userUpdate(userDto);
        if (userResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // userEmail에 해당하는 user 탈퇴
    @DeleteMapping(value = "/user/{userEmail}")
    public ResponseEntity<UserResultDto> delete(@PathVariable String userEmail) { // restapi를 이용해서 http 상태코드를 성공 실패여부로
                                                                                  // 같이
                                                                                  // 넘겨준다.
        UserResultDto userResultDto = userService.userDelete(userEmail);
        if (userResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 유저 평점
    @PostMapping(value = "/user/rate")
    public ResponseEntity<UserResultDto> rate(@RequestBody UserRateDto userRateDto) { // restapi를 이용해서 http 상태코드를 성공
                                                                                      // 실패여부로
                                                                                      // 같이 넘겨준다.
        UserResultDto userResultDto = userService.userRate(userRateDto);
        if (userResultDto.getResult() == SUCCESS) {
            return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // userEmail에 해당하는 user 정보 구하기
    @GetMapping(value = "/user/dupl/{userEmail}")
    public ResponseEntity<UserResultDto> duplEmail(@PathVariable String userEmail) { // restapi를 이용해서 http 상태코드를 성공
                                                                                     // 실패여부로 같이
        // 넘겨준다.
        UserResultDto userResultDto = userService.userDuplEmail(userEmail);
        return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.OK);
    }

    // userEmail에 해당하는 user 정보 구하기
    @GetMapping(value = "/user/dupl/{userNickname}")
    public ResponseEntity<UserResultDto> duplNickname(@PathVariable String userNickname) { // restapi를 이용해서 http 상태코드를
                                                                                           // 성공 실패여부로 같이
        // 넘겨준다.
        UserResultDto userResultDto = userService.userDuplNickname(userNickname);
        return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.OK);
    }
}
