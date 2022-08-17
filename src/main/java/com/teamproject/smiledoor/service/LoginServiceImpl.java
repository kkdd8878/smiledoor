package com.teamproject.smiledoor.service;

import com.teamproject.smiledoor.dto.UserDto;
import com.teamproject.smiledoor.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public int selectUserInfoYn(String memberId, String memberPw) throws Exception {
        return loginMapper.selectUserInfoYn(memberId, memberPw);
    }

    @Override
    public UserDto enrollMembership(String memberId) throws Exception {
        UserDto userDto = loginMapper.enrollMembership(memberId);
        return userDto;
    }

    @Override
    public UserDto findId(String memberName, String memberEmail) throws Exception {
        return loginMapper.findId(memberName,memberEmail);
    }


    @Override
    public String findAdminYn(String memberId) throws Exception {
        return loginMapper.findAdminYn(memberId);
    }

    @Override
    public UserDto findPass(String memberName, String memberEmail, String memberId) throws Exception {
        return loginMapper.findPass(memberName,memberEmail,memberId);
    }


}
