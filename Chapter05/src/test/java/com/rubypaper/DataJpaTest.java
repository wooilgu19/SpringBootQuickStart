package com.rubypaper;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

// 자동설정에 의해 사용자가 작성한 Repository 인터페이스를 모두 찾아 구현 객체를 생성한다.
@SpringBootTest
public class DataJpaTest {

	@Autowired
	private BoardRepository boardRepository;
	
	@Test
	void deleteBoard() {

		// deleteById() 메소드가 UPDATE 기능의 메소드다.
		boardRepository.deleteById(2);
	}
	
	//@Test
	void updateBoard() {
		Board board = new Board();
		board.setSeq(2);
		board.setTitle("Data JPA 테스트-수정");
		board.setWriter("테스터");
		board.setContent("Data JPA 테스트-수정");
		board.setRegDate(new Date());
		board.setCnt(0);
		// save() 메소드가 INSERT 기능의 메소드다.
		boardRepository.save(board);
	}
	
	//@Test
	void getBoardList() {
		//findAll() 메소드는 목록 검색이다.
		List<Board> boardList = boardRepository.findAll();
		System.out.println(" [ 검색 결과 ] ");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
	}
	
//	@Test
	void getBoard() {
//		//findById() 메소드는 상세 조회다.
//		Optional<Board> findObject = boardRepository.findById(2);
//		if(findObject.isPresent()) {
//			Board board = findObject.get();
//			System.out.println("검색 결과 : " + board.toString());
//		}
		
		Board board = boardRepository.findById(1).get();
		System.out.println("검색 결과 : " + board.toString());
	}
	
	//@Test
	void insertBoard() {
		Board board = new Board();
		board.setTitle("Data JPA 테스트");
		board.setWriter("테스터");
		board.setContent("Data JPA 테스트");
		board.setRegDate(new Date());
		board.setCnt(0);
		// save() 메소드가 INSERT 기능의 메소드다.
		boardRepository.save(board);
	}
}







