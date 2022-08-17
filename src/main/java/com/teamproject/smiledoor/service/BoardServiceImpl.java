package com.teamproject.smiledoor.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.teamproject.smiledoor.common.FileUtils;
import com.teamproject.smiledoor.dto.BoardDto;
import com.teamproject.smiledoor.dto.BoardFileDto;
import com.teamproject.smiledoor.dto.CommentDto;
import com.teamproject.smiledoor.mapper.BoardMapper;
import com.teamproject.smiledoor.mapper.Comment2Mapper;
import com.teamproject.smiledoor.mapper.CommentMapper;
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
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private Comment2Mapper comment2Mapper;
    @Override
    public Page<BoardDto> getBoardListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 10);
        return boardMapper.getBoardListPage();
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
    public void updateBoard(BoardDto board, MultipartHttpServletRequest multiUploadFiles) throws Exception {
        boardMapper.updateBoard(board);
        List<BoardFileDto> fileList = fileUtils.parseFileInfo(board.getBoardNum(),multiUploadFiles);
        if(CollectionUtils.isEmpty(fileList) == false){
            boardMapper.insertBoardFileList(fileList);
        }
    }
    @Override
    public void deleteBoard(int boardNum) throws Exception {
        boardMapper.deleteBoard(boardNum);
    }
    @Override
    public BoardFileDto selectBoardFileInfo(int idx, int boardNum) throws Exception {
        return boardMapper.selectBoardFileInfo(idx, boardNum);
    }
    @Override
    public void deleteBoardFile(int idx, int boardNum) throws Exception {
        boardMapper.deleteBoardFile(idx,boardNum);
    }
    @Override
    public List<CommentDto> commentListService() throws Exception {
        return commentMapper.commentList();
    }
    @Override
    public int commentInsertService(CommentDto comment) throws Exception {
        return commentMapper.commentInsert(comment);
    }
    @Override
    public int commentUpdateService(CommentDto comment) throws Exception {
        return commentMapper.commentUpdate(comment);
    }
    @Override
    public int commentDeleteService(int commentNum) throws Exception {
        return commentMapper.commentDelete(commentNum);
    }
    @Override
    public void insertComment(CommentDto comment) throws Exception {
        commentMapper.insertComment(comment);
    }

    @Override
    public List<CommentDto> comment2ListService() throws Exception {
        return comment2Mapper.commentList();
    }

    @Override
    public int comment2UpdateService(CommentDto comment) throws Exception {
        return comment2Mapper.commentUpdate(comment);
    }
    @Override
    public int comment2DeleteService(int commentNum) throws Exception {
        return comment2Mapper.commentDelete(commentNum);
    }
    @Override
    public void insert2Comment(CommentDto comment) throws Exception {
        comment2Mapper.insertComment(comment);
    }


}