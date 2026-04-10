package com.rubypaper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rubypaper.domain.User;
import com.rubypaper.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {	
	
	// BoardService 타입의 객체(BoardServiceImpl)를 주입한다.
	@Autowired
	private UserService userService;
	
	// 글 등록 화면으로 이동
	@GetMapping("/loginView.do")
	public String loginView() {
		return "login";
	}
	
	//로그인 인증 처리
	@PostMapping("/login.do")
	public String login(User user,HttpSession session) {
		User findUser = userService.getUser(user);
		
		//검색한 회원의 비번 체크
		if(findUser != null && findUser.getPassword().equals(user.getPassword())) {
			session.setAttribute("user", findUser);
			return "redirect:getBoardList.do";
		}
		
		return "redirect:loginView.do";
	}
	
	// 로그아웃 화면으로 이동
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}





