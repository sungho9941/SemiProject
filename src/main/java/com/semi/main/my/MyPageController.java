package com.semi.main.my;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/my/*")
public class MyPageController {

	@Autowired
	MyPageService myPageService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET) //로그인 테스트용으로 나중에 삭제
	public void getLogin() throws Exception{
		
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST) //로그인 테스트용으로 나중에 삭제
	public String getLogin(MyPageDTO myPageDTO, HttpSession session) throws Exception{
		myPageDTO = myPageService.getLogin(myPageDTO);
		
		System.out.println(myPageDTO.getUserId()+"=====");
		System.out.println(myPageDTO.getUserPw());
		System.out.println(myPageDTO.getName());	
		
		
		if(myPageDTO != null) {
			session.setAttribute("my", myPageDTO);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String getList(MyPageDTO myPageDTO, Model model) throws Exception{
		myPageService.getList(myPageDTO);
		System.out.println(myPageDTO.getName()+"list");
		System.out.println(myPageDTO.getUserId());
		System.out.println(myPageDTO.getUserPw());
		
		model.addAttribute("list", myPageDTO);
		return "/home";
	}
	
	
}
