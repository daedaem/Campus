package com.ssafy.project.dao;

import com.ssafy.project.dto.SnsReplyDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SnsReplyDao {
    public int SnsReplyCount();

    public int SnsReplyInsert(SnsReplyDto snsReplyNo);
    public int SnsReplyDelete(int snsReplyNo);
    public int SnsReplyUpdate(SnsReplyDto dto);

    

}
