package com.semi.main.my;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.semi.main.file.FileDTO;
import com.semi.main.member.MemberDTO;
import com.semi.main.member.MemberFileDTO;
import com.semi.main.product.ProductFileDTO;
import com.semi.main.util.FileManager;

@Service
public class MyPageService {

	@Autowired
	private MyPageDAO myPageDAO;
	@Autowired
	private FileManager fileManager;

	//회원수정
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception{ 
		return myPageDAO.setMemberUpdate(memberDTO);
	}

	// 사진등록
	public String setContentsImg(MultipartFile file, HttpSession session) throws Exception {
		String path="/resources/upload/member/";
		String fileName = fileManager.fileSave(path, session, file); // -> fileName ------> insert 해야됨
		session.setAttribute("newFileName", fileName);
		
		
//		-------
		MemberDTO mem = (MemberDTO)session.getAttribute("member");
		Long userNo = mem.getUserNo();
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setFileName(fileName);
		memberFileDTO.setUserNo(userNo);
		memberFileDTO.setOriginalName(file.getOriginalFilename());
		int result = myPageDAO.setFileJoin(memberFileDTO);

    
		System.out.println(path+fileName+"아");

//		--------
		
		
		return path+fileName; // -5. 선택한 이미지가 실제로 존재하는 경로를 반환 -
	}
	
	// 회원탈퇴
	public int setDelete(MemberDTO memberDTO) throws Exception{ 
		return myPageDAO.setDelete(memberDTO);
	}
	
	
	// 채팅 내역 저장
    public void saveChatMessage(String userId, String message) throws Exception {
        myPageDAO.saveChatMessage(userId, message);
    }

    // 채팅 내역 불러오기
    public List<ChatMessageDTO> getChatMessages(String userId) throws Exception {
        return myPageDAO.getChatMessages(userId);
    }
    
    // 찜목록
    public List<DibsDTO> getDibs(Long userNo) throws Exception{
        return myPageDAO.getDibs(userNo);
     }
    


}