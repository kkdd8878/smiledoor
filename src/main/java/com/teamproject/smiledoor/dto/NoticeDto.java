package com.teamproject.smiledoor.dto;

import lombok.Data;

@Data
public class NoticeDto {
    private int noticeNum;
    private String noticeTitle;
    private String noticeContent;
    private int readCount;
    private String regDate;
}
