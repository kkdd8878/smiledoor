package com.teamproject.smiledoor.service;

import com.teamproject.smiledoor.dto.UserDto;
import com.teamproject.smiledoor.mapper.MemberMapper;
import com.teamproject.smiledoor.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberMapper memberMapper;

    @Autowired
    NoticeMapper noticeMapper;

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

    @Override
    public UserDto idCall(String memberId) throws Exception {
        UserDto user = memberMapper.idCall(memberId);
        return user;
    }

    @Override
    public void updateInfo(UserDto member) throws Exception {
        memberMapper.updateInfo(member);
    }

    @Override
    public void deleteMember(String memberId) throws Exception {
        memberMapper.deleteMember(memberId);
    }

    @Override
    public int emailCheck(String memberEmail) {
        int cnt1 = memberMapper.emailCheck(memberEmail);
        return cnt1;
    }

}
