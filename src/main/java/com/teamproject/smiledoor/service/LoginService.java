package com.teamproject.smiledoor.service;

import com.teamproject.smiledoor.dto.UserDto;

import java.util.List;

public interface LoginService {
    int selectUserInfoYn(String memberId, String memberPw) throws Exception;

    UserDto enrollMembership(String memberId) throws Exception;


    UserDto findId(String memberName, String memberEmail)throws Exception;

    String findAdminYn(String memberId) throws Exception;

    UserDto findPass(String memberName, String memberEmail, String memberId)throws Exception;
}
