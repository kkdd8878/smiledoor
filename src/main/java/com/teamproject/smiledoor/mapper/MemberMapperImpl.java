package com.teamproject.smiledoor.mapper;

import com.teamproject.smiledoor.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberMapperImpl implements MemberMapper{

    @Autowired
    private SqlSession sqlSession;

    private static final String NAMESPACE = "com.teamproject.smiledoor.mapper.MemberMapper";


    @Override
    public List<UserDto> selectUserList() throws Exception {
        return null;
    }

    @Override
    public void joinMember(UserDto userDto) {

    }

    @Override
    public int checkid(String memberId) throws Exception {
        return 0;
    }

    // 아이디 중복 체크
    @Override
    public int idCheck(String memberId) {
        int cnt = sqlSession.selectOne(NAMESPACE+".idCheck", memberId);
        return cnt;
    }

    @Override
    public UserDto idCall(String memberId) {
        return null;
    }

    @Override
    public void updateInfo(UserDto member) throws Exception {

    }

    @Override
    public void deleteMember(String memberId) throws Exception {

    }

    @Override
    public int emailCheck(String memberEmail){
        int cnt1 = sqlSession.selectOne(NAMESPACE+".emailCheck", memberEmail);
        return cnt1;
    }
}
