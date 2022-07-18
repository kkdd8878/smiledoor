package com.teamproject.smiledoor.dto;

import lombok.Data;

import java.util.List;

@Data
public class BoardDto {
    private int boardNum;
    private String memberId;
    private String boardTitle;
    private String boardContent;
    private int readCount;
    private String regDate;
    private String ip;
    private int reRef;
    private int reLev;
    private int reSeq;
    //    첨부 파일 목록을 저장할 List<BoardFileDto> 객체
    private List<BoardFileDto> fileList;
}
