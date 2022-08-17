package com.teamproject.smiledoor.mapper;

import com.teamproject.smiledoor.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<UserDto> selectUserList() throws Exception;

    void joinMember(UserDto userDto);

    int checkid(String memberId) throws Exception;

    int idCheck(String memberId);

    UserDto idCall(String memberId) throws Exception;

    void updateInfo(UserDto member) throws Exception;

    void deleteMember(String memberId) throws Exception;

    int emailCheck(String memberEmail);

}
