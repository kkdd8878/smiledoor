package com.teamproject.smiledoor.controller;


import com.teamproject.smiledoor.dto.NoticeDto;
import com.teamproject.smiledoor.dto.UserDto;
import com.teamproject.smiledoor.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/notice/noticeList")
    public ModelAndView openNoticeList() throws Exception{
        ModelAndView mv = new ModelAndView("/notice/noticeList");

        List<NoticeDto> dataList = noticeService.selectNoticeList();

        mv.addObject("dataList", dataList);

        return mv;
    }

    @RequestMapping("/notice/WriteBoard")
    public ModelAndView writeBoard(HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView("/notice/noticeWrite");

        HttpSession session = request.getSession();

        UserDto user = new UserDto(); // 아마도 로그인 서비스 생기면 UserDto 로 변경하면됨 변수도 그걸로
        user.setMemberId((String) session.getAttribute("memberId"));
        mv.addObject("user", user);

        return mv;
    }

    @RequestMapping("/notice/insertBoard")
    public String insertBoard(NoticeDto notice, MultipartHttpServletRequest multiUploadFiles) throws Exception{
        noticeService.insertBoard(notice, multiUploadFiles);
        return "redirect:/notice/noticeList";
    }

    @RequestMapping("/notice/noticeDetail")
    public ModelAndView boardDetail(@RequestParam("noticeNum") int noticeNum) throws Exception{
        ModelAndView mv = new ModelAndView("/notice/noticeDetail");

        NoticeDto notice = noticeService.selectNoticeDetail(noticeNum);
        mv.addObject("notice",notice);

        return mv;
    }

    @RequestMapping("/notice/updateBoard")
    public String updateBoard(NoticeDto notice) throws Exception {
        noticeService.updateBoard(notice);
        return  "redirect:/notice/noticeList";
    }

    @RequestMapping("/notice/deleteBoard")
    public String deleteBoard(@RequestParam int noticeNum) throws Exception {
        noticeService.deleteBoard(noticeNum);
        return  "redirect:/notice/noticeList";
    }

}
