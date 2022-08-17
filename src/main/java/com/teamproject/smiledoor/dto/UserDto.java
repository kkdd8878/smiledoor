package com.teamproject.smiledoor.dto;

import lombok.Data;

@Data
public class UserDto {
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberEmail;
    private String birthDay;
    private String phone;
    private String regDate;
    private String adminYn;

}
