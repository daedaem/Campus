package com.ssafy.project.controller;

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

import com.ssafy.project.dto.FollowDto;
import com.ssafy.project.service.FollowService;

@CrossOrigin(origins = "http://localhost:5500", allowCredentials = "true", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.OPTIONS })
@RestController // 값자체를 리턴
public class FollowController {

    @Autowired
    FollowService followService;

    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    // follow 추가
    @PostMapping(value = "/follow")
    public ResponseEntity<Integer> insert(int userNo, int followUserNo) {
        if (followService.followInsert(userNo, followUserNo) == SUCCESS) {
            return new ResponseEntity<Integer>(SUCCESS, HttpStatus.OK);
        } else {
            return new ResponseEntity<Integer>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // follow, follower 수 구하기
    @GetMapping(value = "/follow/num/{userNo}")
    public ResponseEntity<FollowDto> followNum(@PathVariable int userNo) {
        FollowDto follow = new FollowDto();
        follow.setFollowNum(followService.followNum(userNo));
        follow.setFollowerNum(followService.followerNum(userNo));
        return new ResponseEntity<FollowDto>(follow, HttpStatus.OK);
    }

    // follow list
    @GetMapping(value = "/follow/{userNo}")
    public ResponseEntity<FollowDto> followSelect(@PathVariable int userNo) {
        FollowDto follow = new FollowDto();
        follow.setFollow(followService.followList(userNo));
        return new ResponseEntity<FollowDto>(follow, HttpStatus.OK);
    }

    // follower list
    @GetMapping(value = "/follower/{followUserNo}")
    public ResponseEntity<FollowDto> followerSelect(@PathVariable int followUserId) {
        FollowDto follower = new FollowDto();
        follower.setFollower(followService.followerList(followUserId));
        return new ResponseEntity<FollowDto>(follower, HttpStatus.OK);
    }

    // follow 취소
    @DeleteMapping(value = { "/follow/{userNo}/{followUserNo}" })
    public ResponseEntity<Integer> delete(@PathVariable int userNo, @PathVariable int followUserNo) {
        if (followService.followDelete(userNo, followUserNo) == SUCCESS) {
            return new ResponseEntity<Integer>(SUCCESS, HttpStatus.OK);
        } else {
            return new ResponseEntity<Integer>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
