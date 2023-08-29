package com.semi.main.my;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.semi.main.file.FileDTO;
import com.semi.main.util.FileManager;

@Service
public class MyPageService {

	@Autowired
	private MyPageDAO myPageDAO;
	@Autowired
	private FileManager fileManager;
	
	public int setJoin(MemberDTO memberDTO, MultipartFile multipartFile, HttpSession session) throws Exception{ // 회원가입-나중에 삭제
		
		String path="/resources/upload/member/";
		int result = myPageDAO.setJoin(memberDTO);
		
		if(!multipartFile.isEmpty()) {
		String fileName = fileManager.fileSave(path, session, multipartFile);
		MyPageFileDTO myPageFileDTO = new MyPageFileDTO();
		myPageFileDTO.setUserNo(memberDTO.getUserNo());
		myPageFileDTO.setOriginalFileName(multipartFile.getOriginalFilename());
		myPageFileDTO.setFileName(fileName);
		result = myPageDAO.setFileJoin(myPageFileDTO);
		}
		
		return result;
	}
	
	public MemberDTO getLogin(MemberDTO myPageDTO) throws Exception{ //로그인 삭제예정
		return myPageDAO.getLogin(myPageDTO);
	}
	
	public List<MemberDTO> getList(MemberDTO myPageDTO) throws Exception{ //삭제예정
		return myPageDAO.getList(myPageDTO);
	}
	
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception{ //회원수정 메서드
		return myPageDAO.setMemberUpdate(memberDTO);
	}
	



	public boolean setContentsImgDelete(String path, HttpSession session)throws Exception{
		//path: /resources/upload/notice/파일명
		FileDTO fileDTO = new FileDTO();
		System.out.println(path.substring(path.lastIndexOf("/")+1));
		fileDTO.setFileName(path.substring(path.lastIndexOf("/")+1));
		
		//path = path.substring(0, path.lastIndexOf("\\")+1);
		path= "/resources/upload/member/";
		return fileManager.fileDelete(fileDTO, path, session);
	}
	
	public String setContentsImg(MultipartFile file, HttpSession session) throws Exception {
		String path="/resources/upload/member/";
		String fileName = fileManager.fileSave(path, session, file); // -> fileName ------> insert 해야됨
		
		
//		-------
		MemberDTO mem = (MemberDTO)session.getAttribute("member");
		Long userNo = mem.getUserNo();
		MyPageFileDTO myPageFileDTO = new MyPageFileDTO();
		myPageFileDTO.setFileName(fileName);
		myPageFileDTO.setUserNo(userNo);
		myPageFileDTO.setOriginalFileName(file.getOriginalFilename());
		int result = myPageDAO.setFileJoin(myPageFileDTO);
//		--------
		
		
		return path+fileName; // -5. 선택한 이미지가 실제로 존재하는 경로를 반환 -
	}
	
	public int setFileDelete(MyPageFileDTO myPageFileDTO, HttpSession session)throws Exception{
		//폴더 파일 삭제
		myPageFileDTO = myPageDAO.getFileDetail(myPageFileDTO);
		boolean flag = fileManager.fileDelete(myPageFileDTO, "/resources/upload/member/", session);
		
		if(flag) {
			//db 삭제
			return myPageDAO.setFileDelete(myPageFileDTO);
		}
		return 0;
	}
	
	public int setDelete(MemberDTO memberDTO) throws Exception{ //회원탈퇴
		return myPageDAO.setDelete(memberDTO);
	}
	

}
