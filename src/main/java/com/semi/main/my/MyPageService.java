package com.semi.main.my;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPageService {

	@Autowired
	private MyPageDAO myPageDAO;
	
	public MyPageDTO getLogin(MyPageDTO myPageDTO) throws Exception{
		return myPageDAO.getLogin(myPageDTO);
	}
	
	public List<MyPageDTO> getList(MyPageDTO myPageDTO) throws Exception{
		return myPageDAO.getList(myPageDTO);
	}
}
