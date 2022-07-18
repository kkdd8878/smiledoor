package com.teamproject.smiledoor.service;


import com.teamproject.smiledoor.common.FileUtils;
import com.teamproject.smiledoor.dto.BoardDto;
import com.teamproject.smiledoor.dto.BoardFileDto;
import com.teamproject.smiledoor.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {


    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private FileUtils fileUtils;

    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return boardMapper.selectBoardList();
    }

    @Override
    public void insertBoard(BoardDto board, MultipartHttpServletRequest multiUploadFiles) throws Exception {
        boardMapper.insertBoard(board);

        List<BoardFileDto> fileList = fileUtils.parseFileInfo(board.getBoardNum(),multiUploadFiles);

        if(CollectionUtils.isEmpty(fileList) == false){
            boardMapper.insertBoardFileList(fileList);
        }

    }

    @Override
    public BoardDto selectBoardDetail(int boardNum) throws Exception {
        boardMapper.updateReadCount(boardNum);
        BoardDto board = boardMapper.selectBoardDetail(boardNum);

        List<BoardFileDto> fileList = boardMapper.selectBoardFileList(boardNum);
        board.setFileList(fileList);

        return board;
    }

    @Override
    public void updateBoard(BoardDto board) throws Exception {
        boardMapper.updateBoard(board);
    }

    @Override
    public void deleteBoard(int boardNum) throws Exception {
        boardMapper.deleteBoard(boardNum);
    }

    @Override
    public BoardFileDto selectBoardFileInfo(int idx, int boardNum) throws Exception {
        return boardMapper.selectBoardFileInfo(idx, boardNum);
    }
}