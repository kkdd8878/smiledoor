package com.teamproject.smiledoor.service;

import com.github.pagehelper.Page;
import com.teamproject.smiledoor.dto.NoticeDto;
import com.teamproject.smiledoor.dto.UserDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface NoticeService {
    Page<NoticeDto> getNoticeListPage(int pageNum) throws Exception;

    void insertBoard(NoticeDto notice, MultipartHttpServletRequest multiUploadFiles) throws Exception;

    NoticeDto selectNoticeDetail(int noticeNum) throws Exception;

    void updateBoard(NoticeDto notice)throws Exception;

    void deleteBoard(int noticeNum)throws Exception;


}
