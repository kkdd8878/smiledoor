package com.teamproject.smiledoor.mapper;
import com.teamproject.smiledoor.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeMapper {
    List<NoticeDto> selectNoticeList() throws Exception;

    void insertBoard(NoticeDto notice)throws Exception;

    void updateReadCount(int noticeNum) throws Exception;

    NoticeDto selectNoticeDetail(int noticeNum) throws Exception;

    void updateBoard(NoticeDto notice) throws Exception;

    void deleteBoard(@Param("noticeNum") int noticeNum) throws Exception;
}
