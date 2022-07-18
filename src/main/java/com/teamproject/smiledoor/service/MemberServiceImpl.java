package com.teamproject.smiledoor.service;

import com.teamproject.smiledoor.dto.UserDto;
import com.teamproject.smiledoor.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberMapper memberMapper;

    @Override
    public List<UserDto> selectUserList() throws Exception {
        return memberMapper.selectUserList();
    }

    @Override
    public void joinMember(UserDto userDto) throws Exception {
        memberMapper.joinMember(userDto);
    }

    @Override
    public int checkid(String memberId) throws Exception {
        return memberMapper.checkid(memberId);
    }
    @Override
    public int idCheck(String memberId) {
        int cnt = memberMapper.idCheck(memberId);
        return cnt;
    }
}
