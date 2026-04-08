package com.rubypaper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;

@SpringBootTest
public class MyBatisTest {

	// MyBatisAutoConfiguration
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Test
	void getBoardList() {
		List<Board> boardList = mybatis.selectList("getBoardList");
		System.out.println("[ 검색 결과 ]");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}

	//@Test
	void insertBoard() {
		Board board = new Board();
		board.setTitle("MyBatis 테스트");
		board.setWriter("테스터");
		board.setContent("MyBatis 테스트 중입니다.");
		mybatis.insert("insertBoard", board);
	}

}
