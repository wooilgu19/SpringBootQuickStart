package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rubypaper.domain.Board;

@Controller
public class BoardController {
		
	@GetMapping("/getBoardList.do")
	public String getBoardList(Model model) {
		System.out.println("---> getBoardList() 호출됨");
		List<Board> boardList = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			Board board = new Board();
			board.setSeq(i);
			board.setTitle("Spring Boot 테스트-" + i);
			board.setWriter("테스터");
			board.setContent("Spring Boot 테스트 중입니다.-" + i);
			board.setRegDate(new Date());
			board.setCnt(0);
			boardList.add(board);
		}
		
		//Model
		model.addAttribute("boardList",boardList);
		return "getBoardList.jsp";
	}
}





