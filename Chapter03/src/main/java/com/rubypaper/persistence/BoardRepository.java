package com.rubypaper.persistence;

import org.springframework.stereotype.Repository;

@Repository
public class BoardRepository {
	public BoardRepository() {
		System.out.println("---> BoardRepository 생성");
	}

}
