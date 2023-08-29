package com.semi.main.my;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	@RequestMapping(value = "join", method = RequestMethod.POST)  // 회원가입 테스트용으로 나중에 삭제
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
	
	@RequestMapping(value = "test", method = RequestMethod.GET) //회원목록 출력 테스트 - 나중에 삭제
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
	public String list(MemberDTO myPageDTO) throws Exception{
		return "./my/list";
	}
	
	@PostMapping("setContentsImgDelete")
	public String setContentsImgDelete(String path, HttpSession session, Model model)throws Exception{
		boolean check= myPageService.setContentsImgDelete(path, session);
		model.addAttribute("result", check);
		return "commons/ajaxResult";
	}
	
	// 4. AJAX로 넘긴 파일 데이터를 처리
	@PostMapping("setContentsImg")
	public String setContentsImg(MultipartFile file, HttpSession session, Model model)throws Exception{
		String path = myPageService.setContentsImg(file, session);
		model.addAttribute("result", path);
		return "commons/ajaxResult";
		
	}
	
	@GetMapping("fileDelete")
	public String setFileDelete(MyPageFileDTO myPageFileDTO, HttpSession session ,Model model)throws Exception{
		int result = myPageService.setFileDelete(myPageFileDTO, session);
		model.addAttribute("result", result);
		return "commons/ajaxResult";
		
	}
	
	@GetMapping("delete")
	public void setDelete(MemberDTO memberDTO) throws Exception{ //회원탈퇴

	}
	
	@PostMapping("delete")
	public String setDelete(MemberDTO memberDTO, HttpSession session, Model model) throws Exception{ //회원탈퇴
		MemberDTO mem = (MemberDTO)session.getAttribute("member");
		String sessionPass = mem.getUserPw();
		String pass = memberDTO.getUserPw();
		
		String message = "탈퇴 성공하셨습니다";
		if(!(sessionPass.equals(pass))) {
			message = "비밀번호를 다시 입력해주세요";
			model.addAttribute("message", message);
			model.addAttribute("url", "./delete");	
		} else {
		model.addAttribute("message", message);
		model.addAttribute("url", "../");	
		myPageService.setDelete(memberDTO);
		session.invalidate();
		}
		
		return "commons/result";
	}
	
//	@GetMapping("list")
//	public void getMyList(Model model, HttpSession session) throws Exception{ //?
//		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
//		List<MemberDTO> ar1 = myPageService.getMyList(memberDTO);
//		model.addAttribute("member", ar1);
//		
//	}
}
