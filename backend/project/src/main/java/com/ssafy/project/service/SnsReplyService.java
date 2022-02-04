package com.ssafy.project.service;

import com.ssafy.project.dto.SnsReplyDto;
import com.ssafy.project.dto.SnsReplyResultDto;

public interface SnsReplyService {
    
    public SnsReplyResultDto snsReplyList(int snsReplyNo);
    
    public SnsReplyResultDto snsReplyInsert(SnsReplyDto dto);
    
    public SnsReplyResultDto snsReplyDelete(int snsReplyNo);
    
    public SnsReplyResultDto snsReplyUpdate(SnsReplyDto dto);
}
