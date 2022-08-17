package com.teamproject.smiledoor.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.teamproject.smiledoor.dto.NoticeDto;
import com.teamproject.smiledoor.dto.UserDto;
import com.teamproject.smiledoor.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public Page<NoticeDto> getNoticeListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 10);
        return noticeMapper.getNoticeListPage();
    }

    @Override
    public void insertBoard(NoticeDto notice, MultipartHttpServletRequest multiUploadFiles) throws Exception {
        noticeMapper.insertBoard(notice);
    }

    @Override
    public NoticeDto selectNoticeDetail(int noticeNum) throws Exception {
        noticeMapper.updateReadCount(noticeNum);
        NoticeDto notice = noticeMapper.selectNoticeDetail(noticeNum);

        return notice;
    }

    @Override
    public void updateBoard(NoticeDto notice) throws Exception {
        noticeMapper.updateBoard(notice);
    }

    @Override
    public void deleteBoard(int noticeNum) throws Exception {
        noticeMapper.deleteBoard(noticeNum);
    }



}
