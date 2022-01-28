package com.ssafy.project.service;

import com.ssafy.project.dto.SnsReplyDto;
import com.ssafy.project.dto.SnsReplyResultDto;

public interface SnsReplyService {
    
    public SnsReplyResultDto snsReplyList(int snsReplyNo);
    
    public SnsReplyResultDto SnsReplyInsert(SnsReplyDto dto);
    
    public SnsReplyResultDto SnsReplyDelete(int snsReplyNo);
    
    public SnsReplyResultDto SnsReplyUpdate(SnsReplyDto dto);
}
