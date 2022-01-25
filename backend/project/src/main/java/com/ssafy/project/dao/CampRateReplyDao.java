package com.ssafy.project.dao;

import java.util.List;

import com.ssafy.project.dto.CampRateReplyDto;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
public interface CampRateReplyDao {
    // 캠핑장 평점 댓글 리스트
    public List<CampRateReplyDto> campRateReplyList(int campRateNo);

    // 캠핑장 평점 댓글 개수
    public int campRateReplyListTotalCount(int campRateNo);

    // 캠핑장 평점 댓글 추가
    public int campRateReplyInsert(CampRateReplyDto campRateReplyDto);

    // 캠핑장 평점 댓글 수정
    public int campRateReplyUpdate(CampRateReplyDto campRateReplyDto);

    // 캠핑장 평점 댓글 삭제
    public int campRateReplyDelete(int campRateReplyNo);
}
