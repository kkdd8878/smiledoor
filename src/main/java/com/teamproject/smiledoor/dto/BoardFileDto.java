package com.teamproject.smiledoor.dto;

import lombok.Data;

@Data
public class BoardFileDto {
    private int idx;
    private int boardNum;
    private String filename;
    private String uploadpath;
    private long fileSize;
}
