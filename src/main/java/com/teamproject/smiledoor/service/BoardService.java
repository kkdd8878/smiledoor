package com.teamproject.smiledoor.service;

import com.github.pagehelper.Page;
import com.teamproject.smiledoor.dto.BoardDto;
import com.teamproject.smiledoor.dto.BoardFileDto;
import com.teamproject.smiledoor.dto.CommentDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface BoardService {


    Page<BoardDto> getBoardListPage(int pageNum) throws Exception;

    void insertBoard(BoardDto board, MultipartHttpServletRequest multiUploadFiles) throws Exception;

    BoardDto selectBoardDetail(int boardNum) throws Exception;

    void updateBoard(BoardDto board, MultipartHttpServletRequest multiUploadFiles) throws Exception;

    void deleteBoard(int boardNum) throws Exception;

    BoardFileDto selectBoardFileInfo(int idx, int boardNum) throws Exception;

    void deleteBoardFile(int idx, int boardNum) throws Exception;

    List<CommentDto> commentListService() throws Exception;
    int commentInsertService(CommentDto comment) throws Exception;
    int commentUpdateService(CommentDto comment)throws Exception;
    int commentDeleteService(int commentNum)throws Exception;
   void insertComment(CommentDto comment)throws Exception;

    List<CommentDto> comment2ListService() throws Exception;
    int comment2UpdateService(CommentDto comment)throws Exception;
    int comment2DeleteService(int commentNum)throws Exception;
    void insert2Comment(CommentDto comment)throws Exception;

}