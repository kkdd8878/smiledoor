package com.teamproject.smiledoor.mapper;

import com.teamproject.smiledoor.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginMapper {

    int selectUserInfoYn(String memberId, String memberPw) throws Exception;

    UserDto enrollMembership(String memberId) throws Exception;


    UserDto findId(String memberName, String memberEmail)throws Exception;

    String findAdminYn(String memberId) throws Exception;

    UserDto findPass(String memberName, String memberEmail, String memberId)throws Exception;
}
