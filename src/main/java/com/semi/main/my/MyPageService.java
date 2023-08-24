package com.semi.main.my;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.semi.main.util.FileManager;

@Service
public class MyPageService {

	@Autowired
	private MyPageDAO myPageDAO;
	@Autowired
	private FileManager fileManager;
	
	public int setJoin(MemberDTO memberDTO, MultipartFile multipartFile, HttpSession session) throws Exception{ // 나중에 삭제
		String path="/resources/upload/member/";

		int result = myPageDAO.setJoin(memberDTO);
		
		if(!multipartFile.isEmpty()) {
		String fileName = fileManager.fileSave(path, session, multipartFile);
		
		MyPageFileDTO memberFileDTO = new MyPageFileDTO();
		memberFileDTO.setUserNo(memberDTO.getUserId());
		memberFileDTO.setOriginalFileName(multipartFile.getOriginalFilename());
		memberFileDTO.setFileName(fileName);
		result = myPageDAO.setFileJoin(memberFileDTO);
		
		}
		return result;
	}
	
	public MemberDTO getLogin(MemberDTO myPageDTO) throws Exception{ //삭제예정
		return myPageDAO.getLogin(myPageDTO);
	}
	
	public List<MemberDTO> getList(MemberDTO myPageDTO) throws Exception{ //삭제예정
		return myPageDAO.getList(myPageDTO);
	}
}
