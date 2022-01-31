package com.ssafy.project.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowDto {
    // follow list
    private List<UserDto> follow;
    // follower list
    private List<UserDto> follower;
    // follow 수
    private int followNum;
    // follower 수
    private int followerNum;
}
