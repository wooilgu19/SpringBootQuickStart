package com.rubypaper.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository repository;

	public BoardServiceImpl() {
		System.out.println("---> BoardServiceImpl 생성");
	}

	public String hello(String name) {
		return repository.hello(name);
	}

	public Map<String, Object> getBoard(int seq) {
		return repository.getBoard(seq);
	}

	public List<Map<String, Object>> getBoardList() {
		return repository.getBoardList();

	}
}