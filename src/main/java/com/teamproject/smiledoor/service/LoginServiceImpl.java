package com.teamproject.smiledoor.service;

import com.teamproject.smiledoor.dto.UserDto;
import com.teamproject.smiledoor.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    LoginMapper loginMapper;

    @Override
    public int selectUserInfoYn(String memberId, String memberPw) throws Exception {
        return loginMapper.selectUserInfoYn(memberId, memberPw);
    }

    @Override
    public UserDto enrollMembership(String memberId) throws Exception {
        UserDto userDto = loginMapper.enrollMembership(memberId);
        return userDto;
    }


}
