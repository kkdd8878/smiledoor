package com.teamproject.smiledoor.service;

import com.teamproject.smiledoor.dto.BoardDto;
import com.teamproject.smiledoor.dto.BoardFileDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface BoardService {


    public List<BoardDto> selectBoardList() throws Exception;

    void insertBoard(BoardDto board, MultipartHttpServletRequest multiUploadFiles) throws Exception;

    BoardDto selectBoardDetail(int boardNum) throws Exception;

    void updateBoard(BoardDto board) throws Exception;

    void deleteBoard(int boardNum) throws Exception;

    BoardFileDto selectBoardFileInfo(int idx, int boardNum) throws Exception;
}