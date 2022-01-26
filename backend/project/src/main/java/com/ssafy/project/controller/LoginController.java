package com.ssafy.project.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.JsonNode;
import com.ssafy.project.dto.UserDto;
import com.ssafy.project.dto.UserResultDto;
import com.ssafy.project.service.KaKaoLoginServiceImpl;
import com.ssafy.project.service.LoginService;
import com.ssafy.project.service.UserService;

@CrossOrigin(origins = "http://localhost:5500", allowCredentials = "true", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.OPTIONS })
@RestController // 값자체를 리턴
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/test")
    public String test() {
        return "hi";
    }

    // login 성공 -> session에 등록
    @PostMapping(value = "/login") // post 방식으로 들어옴
    public ResponseEntity<UserDto> login(@RequestBody UserDto dto, HttpSession session) {
        UserDto userDto = loginService.login(dto);
        System.out.println(userDto);
        if (userDto != null) {
            session.setAttribute("userDto", userDto);
            return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<UserDto>(userDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/login/kakao/oauth")
    public String kakaoConnect() {
        StringBuffer url = new StringBuffer();
        url.append("https://kauth.kakao.com/oauth/authorize?");
        url.append("client_id=" + "f7e4963d83bf571c5cdbf7870045979d");
        // url.append("&redirect_uri=http://i6e102.p.ssafy.io/login/kakao/callback");
        url.append("&redirect_uri=http://localhost:8080/login/kakao/callback");
        url.append("&response_type=code");

        System.out.println("kakao login");
        return "redirect:" + url.toString();
    }

    @RequestMapping(value = "/login/kakao/callback", produces = "application/json", method = { RequestMethod.GET,
            RequestMethod.POST })
    public ResponseEntity<UserDto> kakaoLogin(@RequestParam("code") String code, RedirectAttributes ra,
            HttpSession session,
            HttpServletResponse response) throws IOException {
        System.out.println("kakao code:" + code);
        JsonNode access_token = KaKaoLoginServiceImpl.getKakaoAccessToken(code);
        // access_token.get("access_token");
        // System.out.println("access_token:" + access_token.get("access_token"));

        JsonNode userInfo = KaKaoLoginServiceImpl.getKakaoUserInfo(access_token.get("access_token"));

        // Get id
        int userNo = userInfo.get("id").asInt();

        // 유저정보 카카오에서 가져오기 Get properties
        JsonNode properties = userInfo.path("properties");
        JsonNode kakao_account = userInfo.path("kakao_account");
        String userNickname = properties.path("nickname").asText(); // 이름 정보 가져오는 것
        String userEmail = kakao_account.path("email").asText();
        String userName = kakao_account.path("name").asText();
        String userGender = properties.path("custom_field2").asText();
        String userProfileImage = properties.path("profile_image").asText();
        int age = properties.path("custom_field1").asInt();
        String userAge = null;
        if (age >= 10 && age <= 19)
            userAge = "10대";
        else if (age >= 20 && age <= 29)
            userAge = "20대";
        else if (age >= 30 && age <= 39)
            userAge = "30대";
        else if (age >= 40 && age <= 49)
            userAge = "40대";
        else if (age >= 50 && age <= 59)
            userAge = "50대";
        else if (age >= 60 && age <= 69)
            userAge = "60대";
        else if (age >= 70 && age <= 79)
            userAge = "70대";
        else if (age >= 80 && age <= 89)
            userAge = "80대";

        // if (member_name != null) {
        // session.setAttribute("isLogOn", true);
        // session.setAttribute("member_id", member_name); // 여기 if문 안에 내용은 다 삭제해도 됩니다.
        // 제 프로젝트에만 필요한 코드임.
        // }
        System.out.println("id : " + userNo); // 여기에서 값이 잘 나오는 것 확인 가능함.
        System.out.println("name : " + userName);
        System.out.println("email : " + userEmail);

        UserResultDto userResultDto = userService.userDuplEmail(userEmail);
        UserDto dto = new UserDto();
        dto.setUserAge(userAge);
        dto.setUserEmail(userEmail);
        dto.setUserGender(userGender);
        dto.setUserName(userName);
        dto.setUserNo(userNo);
        dto.setUserProfileImage(userProfileImage);
        dto.setUserNickname(userNickname);

        if (userResultDto.getResult() == 1) { // 회원가입
            userResultDto = userService.userRegister(dto);
        }

        UserDto userDto = new UserDto();
        userDto = loginService.kakaoLogin(dto);

        if (userDto != null) {
            session.setAttribute("userDto", userDto);
            session.setAttribute("access_token", access_token.get("access_token"));
            return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<UserDto>(userDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @RequestMapping(value = "/logout")
    // public String logout(HttpSession session) {

    // }

    @RequestMapping(value = "/logout/kakao")
    public String logoutKakao(HttpSession session) {
        String access_token = (String) session.getAttribute("access_token");
        if (access_token != null && !"".equals(access_token)) {
            KaKaoLoginServiceImpl.kakaoLogout(access_token);
            session.removeAttribute("access_token");
            session.removeAttribute("userDto");
        } else {
            System.out.println("access_Token is null");
            // return "redirect:/";
        }
        // return "index";
        return "redirect:/";
    }

}
