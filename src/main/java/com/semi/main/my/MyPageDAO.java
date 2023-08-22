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
	
	public MyPageDTO getLogin(MyPageDTO myPageDTO) throws Exception{
		System.out.println(myPageDTO.getUserId());
		System.out.println(myPageDTO.getUserPw());
		
		return sqlSession.selectOne(NAMESPACE+"getLogin", myPageDTO);
	}
	
	public List<MyPageDTO> getList(MyPageDTO myPageDTO) throws Exception{
		
		return sqlSession.selectList(NAMESPACE+"getList", myPageDTO);
	}
}
