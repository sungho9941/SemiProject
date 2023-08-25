package com.semi.main.my;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyPageDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.semi.main.my.MyPageDAO.";
	
	
	public int setFileJoin(MyPageFileDTO myPageFileDTO) throws Exception{ //회원가입(사진등록)용으로 나중에 삭제
		
		
		
		return sqlSession.insert(NAMESPACE+"setFileJoin", myPageFileDTO);
	}
	
	public int setJoin(MemberDTO memberDTO) throws Exception{ //회원가입용으로 나중에 삭제
		
		
		
		
		return sqlSession.insert(NAMESPACE+"setJoin", memberDTO);
	}
	
	public MemberDTO getLogin(MemberDTO myPageDTO) throws Exception{ //로그인 테스트로 나중에 삭제
		System.out.println(myPageDTO.getUserId());
		System.out.println(myPageDTO.getUserPw());
		
		return sqlSession.selectOne(NAMESPACE+"getLogin", myPageDTO);
	}
	
	public List<MemberDTO> getList(MemberDTO myPageDTO) throws Exception{ //회원 리스트 출력 테스트로 나중에 삭제
		
		return sqlSession.selectList(NAMESPACE+"getList", myPageDTO);
	}
}
