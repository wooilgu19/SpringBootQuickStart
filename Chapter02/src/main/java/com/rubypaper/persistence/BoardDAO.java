package com.rubypaper.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	//SQL 명령어들 등록
	private static final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0) + 1 from board),?,?,?)";
	private static final String BOARD_LIST   = "select * from board order by seq desc";
	
	// Spring JDBC가 제공하는 jdbcTemplate 객체를 의존성 주입한다.
	@Autowired
	private JdbcTemplate spring;
	
	//글 등록
	public void insertBoard(Map<String, Object> board) {
		spring.update(BOARD_INSERT,board.get("title"),board.get("writer"),board.get("content"));
	}
	
	//글 목록 검색
	public List<Map<String, Object>> getBoardList() {
		return spring.queryForList(BOARD_LIST);
	}
	
	
	
	
}
