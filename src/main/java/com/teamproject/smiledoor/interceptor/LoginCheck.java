package com.teamproject.smiledoor.interceptor;

import com.teamproject.smiledoor.dto.UserDto;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheck implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        System.out.println("세션에 저장된 내용: "+(String)session.getAttribute("memberId"));

        UserDto userDto = new UserDto();
        userDto.setMemberId((String) session.getAttribute("memberId"));

        if(userDto.getMemberId() == null) {
            System.out.println("현재상태: 비로그인 상태");
            System.out.println("세션정보: "+(String)session.getAttribute("memberId"));
            response.sendRedirect("/login/loginFail");
            return false;
        } else {
            System.out.println("세션정보: "+(String)session.getAttribute("memberId"));
            session.setMaxInactiveInterval(300);
            return true;
        }
    }
}
