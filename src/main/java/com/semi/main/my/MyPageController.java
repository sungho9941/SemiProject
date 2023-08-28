package com.semi.main.my;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/my/*")
public class MyPageController {

	@Autowired
	MyPageService myPageService;
	
	
	
	@GetMapping(value = "join") // 회원가입 테스트용으로 나중에 삭제
	public void setJoin() throws Exception{
		
	}
	
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String setJoin(MemberDTO memberDTO, MultipartFile pic, HttpSession session) throws Exception{
		
		
		int result = myPageService.setJoin(memberDTO, pic, session);
		
		return "redirect:../";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET) //로그인 테스트용으로 나중에 삭제
	public void getLogin() throws Exception{
		
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST) //로그인 테스트용으로 나중에 삭제
	public String getLogin(MemberDTO memberDTO, HttpSession session) throws Exception{
		memberDTO = myPageService.getLogin(memberDTO);
		if(memberDTO != null) {
			
			session.setAttribute("member", memberDTO);
			
			
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "test", method = RequestMethod.GET) //나중에 삭제
	public String getList(MemberDTO myPageDTO, Model model) throws Exception{
		List<MemberDTO> ar = myPageService.getList(myPageDTO);


		model.addAttribute("list", ar);
		return "../views/home";
	}
	
	@GetMapping(value = "mypage") //마이페이지
	public void myPage(MemberDTO memberDTO) throws Exception{
	
	}
	
	@GetMapping(value = "update") //정보수정
	public void update(MemberDTO memberDTO) throws Exception{
		
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String setMemberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception{
		MemberDTO sessionMember = (MemberDTO)session.getAttribute("member");
		memberDTO.setUserId(sessionMember.getUserId());
		
		int result = myPageService.setMemberUpdate(memberDTO);
		if(result>0) {
			session.setAttribute("member", memberDTO);
		}
		
		return "redirect:./mypage";
	}
	
	@GetMapping(value = "list") // 내판매글/구매내역
	public void list(MemberDTO myPageDTO) throws Exception{
		
	}
}
