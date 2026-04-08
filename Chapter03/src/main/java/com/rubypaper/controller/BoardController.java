package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;
import com.rubypaper.service.BoardService;

// @Component를 포함하는 어노테이션들
// @Configuration : 환경설정 클래스
// @Controller or @RestController : 사용자 요청을 받아들이는 Controller 클래스
// @Service : 비즈니스 로직을 담당하는 서비스 클래스
// @Repository : DB 연동을 담당하는 클래스

//@Controller
@RestController // @RestController = @Controller + @ResponseBody
public class BoardController {
	
	// BoardService 타입의 객체(BoardServiceImpl)를 주입한다.
	@Autowired
	private BoardService boardService;	
	
	
	public BoardController() {
		System.out.println("---> BoardController 생성");
	}
	
	// 브라우저가 GET 방식으로 /hello.do 요청을 전송하면 hello() 메소드를 실행해라.
	// @RequestMapping(value = "/hello.do", method = RequestMethod.GET)
	@GetMapping("/hello.do")
	// @ResponseBody : 리턴되는 자바 객체를 JSON으로 변환하여 브라우저에 전송해라.
	public String hello(String name) {
		System.out.println("---> hello() 호출됨");
		return "hello : " + name;
	}
	
	// 브라우저가 GET 방식으로 /getBoard.do 요청을 전송하면 getBoard() 메소드를 실행해라.
	// @RequestMapping(value = "/getBoard.do", method = RequestMethod.GET)
	@GetMapping("/getBoard.do")
	// @ResponseBody : 리턴되는 자바 객체를 JSON으로 변환하여 브라우저에 전송해라.
	public Map<String, Object> getBoard(int seq) {
		System.out.println("---> getBoard() 호출됨");
		return boardService.getBoard(seq);
	}
		
	
	@GetMapping("/getBoardList.do")
	public List<Map<String, Object>> getBoardList() {
		System.out.println("---> getBoardList() 호출됨");
		return boardService.getBoardList();
	}
}





