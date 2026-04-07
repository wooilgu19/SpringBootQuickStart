package com.rubypaper.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.rubypaper.persistence.BoardDAO;

//내가 작성한 클래스의 객체는 @ComponentScan이 자동으로 생성한다.

@Service
public class BoardService implements ApplicationRunner {
	// @EnableAutoConfiguration이 생성해준 ConnetionManager 객체를 주입한다.
	@Autowired
	private BoardDAO boardDAO;

	// ApplicationRunner를 구현한 객체가 생성되면 run() 메소드가 자동으로 생성한다. 
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Map<String, Object> board = new HashMap<>();
		board.put("title","채규태가 작성한 글 ");
		board.put("writer","채규태");
		board.put("content","잘 들어가겠쥬?");
		boardDAO.insertBoard(board);
		
		List<Map<String,Object>> boardList = boardDAO.getBoardList();
		System.out.println("[ 게시글 목록 ]");
		for(Map<String,Object> row : boardList) {
			System.out.println("---> " + row.toString());
		}
		
	}

}
