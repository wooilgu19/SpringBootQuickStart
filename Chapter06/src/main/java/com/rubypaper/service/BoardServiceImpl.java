package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	public void insertBoard(Board board) {
		boardRepository.save(board);
	}
	
	public void updateBoard(Board board) {
		//수정할 엔티티를 검색한다.
		Board findBoard = boardRepository.findById(board.getSeq()).get();
		
		//제목과 내용을 수정한다.
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepository.save(board);
		
	}
	
	public void deleteBoard(Board board) {
		boardRepository.delete(board);
	}
	
	public Board getBoard(Board board) {
		return boardRepository.findById(board.getSeq()).get();
	}
	
	public List<Board> getBoardList(Board board) {
		return boardRepository.findAll();
	}
}
