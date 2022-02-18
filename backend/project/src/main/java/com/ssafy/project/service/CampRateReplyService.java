package com.ssafy.project.service;

import com.ssafy.project.dto.CampRateReplyDto;
import com.ssafy.project.dto.CampRateReplyResultDto;

public interface CampRateReplyService {
    // 캠핑장 평점 댓글 리스트
    public CampRateReplyResultDto campRateReplyList(int campRateNo);

    // 캠핑장 평점 댓글 추가
    public CampRateReplyResultDto campRateReplyInsert(CampRateReplyDto campRateReplyDto);

    // 캠핑장 평점 댓글 수정
    public CampRateReplyResultDto campRateReplyUpdate(CampRateReplyDto campRateReplyDto);

    // 캠핑장 평점 댓글 삭제
    public CampRateReplyResultDto campRateReplyDelete(int campRateReplyNo);
}
