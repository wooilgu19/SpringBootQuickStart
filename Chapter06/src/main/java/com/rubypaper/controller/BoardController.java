package com.rubypaper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rubypaper.domain.Board;
import com.rubypaper.service.BoardService;

@Controller
public class BoardController {	
	
	// BoardService 타입의 객체(BoardServiceImpl)를 주입한다.
	@Autowired
	private BoardService boardService;
	
	// 글 등록 화면으로 이동
	@GetMapping("/insertBoardView.do")
	public String insertBoardView() {
		return "insertBoard";
	}
	
	// 글 등록
	@PostMapping("/insertBoard.do")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		// 글 등록 성공 후, 글 목록 화면으로 이동한다.
		return "redirect:getBoardList.do";
	}
	
	// 글 수정
	@PostMapping("/updateBoard.do")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "redirect:getBoardList.do";
	}
	
	// 글 삭제
	@GetMapping("/deleteBoard.do")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "redirect:getBoardList.do";
	}
	
	// 글 상세
	@GetMapping("/getBoard.do")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));		
		return "getBoard";
	}
	
	// 글 목록
	@RequestMapping("/getBoardList.do")
	public String getBoardList(Board board, Model model) {
		// Model에 검색 결과를 저장하면 JSP에서 출력할 수 있다. 
		model.addAttribute("boardList", boardService.getBoardList(board));		
		return "getBoardList";
	}
}





