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
		MyPageFileDTO myPageFileDTO = new MyPageFileDTO();
		myPageFileDTO.setUserNo(memberDTO.getUserNo());
		myPageFileDTO.setOriginalFileName(multipartFile.getOriginalFilename());
		myPageFileDTO.setFileName(fileName);
		result = myPageDAO.setFileJoin(myPageFileDTO);
		
		
		System.out.println(myPageFileDTO.getUserNo()+"=1");
		System.out.println(myPageFileDTO.getFileName()+"=2");
		System.out.println(myPageFileDTO.getOriginalFileName()+"=3");
		System.out.println(myPageFileDTO.getFileNo()+"=4");
		System.out.println(memberDTO.getUserNo()+"=5");
		System.out.println(memberDTO.getName()+"=6");
		System.out.println(memberDTO.getPhone()+"=7");
		System.out.println(memberDTO.getUserId()+"=8");
		
		}
		
		
		return result;
	}
	
	public MemberDTO getLogin(MemberDTO myPageDTO) throws Exception{ //삭제예정
		return myPageDAO.getLogin(myPageDTO);
	}
	
	public List<MemberDTO> getList(MemberDTO myPageDTO) throws Exception{ //삭제예정
		return myPageDAO.getList(myPageDTO);
	}
	
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception{ //회원수정 메서드
		return myPageDAO.setMemberUpdate(memberDTO);
	}
}
