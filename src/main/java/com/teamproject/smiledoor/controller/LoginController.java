package com.teamproject.smiledoor.controller;

import com.teamproject.smiledoor.dto.UserDto;
import com.teamproject.smiledoor.service.LoginService;
import com.teamproject.smiledoor.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.PortUnreachableException;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }

    @RequestMapping("/login")
    public String login() throws Exception {
        return "login/login";
    }

    // 세션에 정보 저장, 삭제
    @RequestMapping("/loginCheck")
    public String loginCheck(@RequestParam("memberId") String memberId, @RequestParam("memberPw") String memberPw,
                             HttpServletRequest request) throws Exception {
        int count = loginService.selectUserInfoYn(memberId, memberPw);
        if (count == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("memberId", memberId);
            session.setMaxInactiveInterval(300);
            return "login/loginSuccess";
        }
        else { return "login/loginFail"; }
        }

    @RequestMapping("/loginSuccess")
    public ModelAndView loginOk(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();

        UserDto userDto = new UserDto();
        userDto.setMemberId((String)session.getAttribute("memberId"));

        ModelAndView mv = new ModelAndView("/login/loginSuccess");
        mv.addObject("userDto", userDto);

        return mv;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        // 세션에 저장된 정보 삭제
        session.removeAttribute("memberId");
        // 모든 세션 정보 삭제
        session.invalidate();
        return "login/logout";
    }

    @RequestMapping("/loginFail")
    public String loginFail() throws Exception {
        return "login/loginFail";
    }





//================================================================================

    @RequestMapping("view")
    public ModelAndView viewPage(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("login/viewPage");
        HttpSession session = request.getSession();
        UserDto userDto = new UserDto();
        userDto.setMemberId((String)session.getAttribute("memberId"));
        if (userDto.getMemberId() != null) {
            mv.addObject("memberId", userDto.getMemberId());
        }
        return mv;
    }

    @RequestMapping("/user")
    public class UserController {

        @Autowired
        private MemberService userService;

        // 아이디 체크
        @PostMapping("/idCheck")
        @ResponseBody
        public int idCheck(@RequestParam("memberId") String memberId){
//            logger.info("userIdCheck 진입");
//            logger.info("전달받은 id:"+id);
            int cnt = userService.idCheck(memberId);
//            logger.info("확인 결과:"+cnt);
            return cnt;
        }
    }
}
