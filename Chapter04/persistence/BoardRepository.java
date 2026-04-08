package com.rubypaper.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepository {
	
	@Autowired
	private JdbcTemplate spring;
	
	public BoardRepository() {
		System.out.println("---> BoardRepository 생성");
	}
	
	public String hello(String name) {
		return "hello : " + name;
	}
	
	public Map<String, Object> getBoard(int seq) {
		String sql = "select * from board where seq = ?";
		Object[] args = {seq};
		return spring.queryForMap(sql,args);
	}
	
	public List<Map<String, Object>> getBoardList(){
		String sql = "select * from board order by seq desc";
		return spring.queryForList(sql);
		
	}
	
}
