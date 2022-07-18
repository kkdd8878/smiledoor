package com.teamproject.smiledoor.controller;


import com.teamproject.smiledoor.dto.BoardDto;
import com.teamproject.smiledoor.dto.BoardFileDto;
import com.teamproject.smiledoor.dto.UserDto;
import com.teamproject.smiledoor.service.BoardService;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    //자유게시판
    @RequestMapping("/board/boardList")
    public ModelAndView openBoardList() throws Exception{
        ModelAndView mv = new ModelAndView("/board/boardList");

        List<BoardDto> dataList = boardService.selectBoardList();

        mv.addObject("dataList", dataList);

        return mv;
    }

    //자유게시판 글쓰기
    @RequestMapping("/board/WriteBoard")
    public ModelAndView writeBoard(HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView("/board/boardWrite");

        HttpSession session = request.getSession();

        UserDto user = new UserDto(); // 아마도 로그인 서비스 생기면 UserDto 로 변경하면됨 변수도 그걸로
        user.setMemberId((String) session.getAttribute("memberId"));
        mv.addObject("user", user);

        return mv;
    }

    @RequestMapping("/board/insertBoard")
    public String insertBoard(BoardDto board, MultipartHttpServletRequest multiUploadFiles) throws Exception{
        boardService.insertBoard(board, multiUploadFiles);
        return "redirect:/board/boardList";
    }

    @RequestMapping("/board/boardDetail")
    public ModelAndView boardDetail(@RequestParam("boardNum") int boardNum) throws Exception{
        ModelAndView mv = new ModelAndView("/board/boardDetail");

        BoardDto board = boardService.selectBoardDetail(boardNum);
        mv.addObject("board",board);

        return mv;
    }

    @RequestMapping("/board/updateBoard")
    public String updateBoard(BoardDto board) throws Exception {
        boardService.updateBoard(board);
        return  "redirect:/board/boardList";
    }

    @RequestMapping("/board/deleteBoard")
    public String deleteBoard(@RequestParam int boardNum) throws Exception {
        boardService.deleteBoard(boardNum);
        return  "redirect:/board/boardList";
    }

    @RequestMapping("/board/downloadBoardFile")
    public void downloadBoardFile(@RequestParam("idx") int idx, @RequestParam("boardNum") int boardNum, HttpServletResponse response) throws Exception{
        BoardFileDto boardFile = boardService.selectBoardFileInfo(idx, boardNum);

        if(ObjectUtils.isEmpty(boardFile) == false){
            String fileName = boardFile.getFilename();

            byte[] files = FileUtils.readFileToByteArray(new File(boardFile.getUploadpath()));

            response.setContentType("application/octet-stream");
            response.setContentLength(files.length);

            response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileName,"UTF-8")+"\";");
            response.setHeader("Content-Transfer-Encoding", "binary");

            response.getOutputStream().write(files);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        }
    }

}
