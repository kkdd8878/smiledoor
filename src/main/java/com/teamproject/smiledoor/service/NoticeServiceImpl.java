package com.teamproject.smiledoor.service;

import com.teamproject.smiledoor.dto.NoticeDto;
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
    public List<NoticeDto> selectNoticeList() throws Exception {
        return noticeMapper.selectNoticeList();
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
