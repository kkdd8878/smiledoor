package com.teamproject.smiledoor.service;

import com.teamproject.smiledoor.dto.NoticeDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface NoticeService {
    List<NoticeDto> selectNoticeList() throws Exception;

    void insertBoard(NoticeDto notice, MultipartHttpServletRequest multiUploadFiles) throws Exception;

    NoticeDto selectNoticeDetail(int noticeNum) throws Exception;

    void updateBoard(NoticeDto notice)throws Exception;

    void deleteBoard(int noticeNum)throws Exception;
}
