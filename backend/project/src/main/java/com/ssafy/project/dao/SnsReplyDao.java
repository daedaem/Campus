package com.ssafy.project.dao;

import java.util.List;

import com.ssafy.project.dto.SnsReplyDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SnsReplyDao {
    public int snsReplyCount(int snsReplyNo);
    public List<SnsReplyDto> snsReplyList(int snsNo);
    public int snsReplyInsert(SnsReplyDto dto);
    public int snsReplyDelete(int snsReplyNo);
    public int snsReplyUpdate(SnsReplyDto dto);

    

}
