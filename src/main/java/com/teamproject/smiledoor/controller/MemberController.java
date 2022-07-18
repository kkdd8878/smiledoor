package com.teamproject.smiledoor.controller;

import com.teamproject.smiledoor.dto.UserDto;
import com.teamproject.smiledoor.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;
    //회원 전체 목록 출력
    @RequestMapping("/memberlist")
    public ModelAndView memberList() throws Exception {
        ModelAndView mv = new ModelAndView("/member/memberList");
        List<UserDto> dataList = memberService.selectUserList();
        mv.addObject("dataList", dataList);
        return mv;
    }
    //회원가입 입력 화면을 보여주는 역할
    @RequestMapping("/registerMemberForm")
    public String registerMemberForm() throws Exception {
        return "/member/memberForm";
    }
    // user정보를 database에 저장해주는 역할
    @RequestMapping("/join")
    public String joinMember(UserDto userDto) throws Exception {
//        System.out.print(userDto);
        memberService.joinMember(userDto);
        return "/member/joinSuccess";
    }

    @PostMapping("/idCheck")
    @ResponseBody
    public int idCheck(@RequestParam("memberId") String memberId){
//        logger.info("userIdCheck 진입");
//        logger.info("전달받은 id:"+id);
        int cnt = memberService.idCheck(memberId);
//        logger.info("확인 결과:"+cnt);
        return cnt;
    }
}
