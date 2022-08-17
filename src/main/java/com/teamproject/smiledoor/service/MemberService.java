package com.teamproject.smiledoor.service;

import com.teamproject.smiledoor.dto.UserDto;

import java.util.List;

public interface MemberService {

   List<UserDto> selectUserList() throws Exception;

    void joinMember(UserDto userDto) throws Exception;

    int checkid(String memberId) throws Exception;

    int idCheck(String memberId);

    UserDto idCall(String memberId)throws Exception;

    void updateInfo(UserDto member)throws Exception;

    void deleteMember(String memberId) throws Exception;

  int emailCheck(String memberEmail);
}
