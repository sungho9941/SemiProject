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

@Controller
@RequestMapping("/my/*")
public class MyPageController {

	@Autowired
	MyPageService myPageService;
	
	@GetMapping(value = "join") // 회원가입 테스트용으로 나중에 삭제
	public void setJoin() throws Exception{
		
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET) //로그인 테스트용으로 나중에 삭제
	public void getLogin() throws Exception{
		
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST) //로그인 테스트용으로 나중에 삭제
	public String getLogin(MyPageDTO myPageDTO, HttpSession session) throws Exception{
		myPageDTO = myPageService.getLogin(myPageDTO);
		
		if(myPageDTO != null) {
			session.setAttribute("member", myPageDTO);
			System.out.println(myPageDTO.getUserId()+"---");
			System.out.println(myPageDTO.getUserPw()+"---");
			
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "test", method = RequestMethod.GET) //나중에 삭제
	public String getList(MyPageDTO myPageDTO, Model model) throws Exception{
		List<MyPageDTO> ar = myPageService.getList(myPageDTO);


		model.addAttribute("list", ar);
		return "../views/home";
	}
	
	@GetMapping(value = "mypage")
	public void myPage(MyPageDTO myPageDTO) throws Exception{
		
	}
}
