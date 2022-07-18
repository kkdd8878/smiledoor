package com.teamproject.smiledoor.mapper;

import com.teamproject.smiledoor.dto.BoardDto;
import com.teamproject.smiledoor.dto.BoardFileDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDto> selectBoardList() throws Exception;

    void insertBoard(BoardDto board) throws Exception;

    BoardDto selectBoardDetail(int boardNum) throws Exception;

    void updateReadCount(int boardNum) throws Exception;

    void updateBoard(BoardDto board) throws Exception;

    void deleteBoard(@Param("boardNum") int boardNum) throws Exception;


    void insertBoardFileList(List<BoardFileDto> fileList) throws Exception;

    List<BoardFileDto> selectBoardFileList(int boardNum) throws Exception;

    BoardFileDto selectBoardFileInfo(@Param("idx") int idx, @Param("boardNum") int boardNum) throws Exception;
}