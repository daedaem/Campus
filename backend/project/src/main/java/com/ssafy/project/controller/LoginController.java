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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.JsonNode;
import com.ssafy.project.dto.UserDto;
import com.ssafy.project.service.KakaoUserInfo;
import com.ssafy.project.service.Kakao_restapi;
import com.ssafy.project.service.LoginService;

@CrossOrigin(origins = "http://localhost:5500", allowCredentials = "true", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.OPTIONS })
@RestController // 값자체를 리턴
public class LoginController {

    @Autowired
    LoginService loginService;

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

    private Kakao_restapi kakao_restapi = new Kakao_restapi();

    @GetMapping(value = "/login/kakao/oauth")
    public String kakaoConnect() {
        StringBuffer url = new StringBuffer();
        url.append("https://kauth.kakao.com/oauth/authorize?");
        url.append("client_id=" + "f7e4963d83bf571c5cdbf7870045979d");
        url.append("&redirect_uri=http://localhost:8080/login/kakao/callback");
        url.append("&response_type=code");

        System.out.println("kakao login");
        return "redirect:" + url.toString();
    }

    @RequestMapping(value = "/login/kakao/callback", produces = "application/json", method = { RequestMethod.GET,
            RequestMethod.POST })
    public String kakaoLogin(@RequestParam("code") String code, RedirectAttributes ra, HttpSession session,
            HttpServletResponse response) throws IOException {

        System.out.println("kakao code:" + code);
        JsonNode access_token = Kakao_restapi.getKakaoAccessToken(code);
        // access_token.get("access_token");
        // System.out.println("access_token:" + access_token.get("access_token"));

        JsonNode userInfo = KakaoUserInfo.getKakaoUserInfo(access_token.get("access_token"));

        // Get id
        String member_id = userInfo.get("id").asText();

        String member_name = null;

        // 유저정보 카카오에서 가져오기 Get properties
        JsonNode properties = userInfo.path("properties");
        JsonNode kakao_account = userInfo.path("kakao_account");
        member_name = properties.path("nickname").asText(); // 이름 정보 가져오는 것
        String email = kakao_account.path("email").asText();
        // if (member_name != null) {
        // session.setAttribute("isLogOn", true);
        // session.setAttribute("member_id", member_name); // 여기 if문 안에 내용은 다 삭제해도 됩니다.
        // 제 프로젝트에만 필요한 코드임.
        // }
        System.out.println("id : " + member_id); // 여기에서 값이 잘 나오는 것 확인 가능함.
        System.out.println("name : " + member_name);
        System.out.println("email : " + email);

        return "redirect:/index.do";
    }
}
