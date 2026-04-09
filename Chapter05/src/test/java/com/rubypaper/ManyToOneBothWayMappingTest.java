package com.rubypaper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.User;
import com.rubypaper.persistence.BoardRepository;
import com.rubypaper.persistence.UserRepository;

@SpringBootTest
public class ManyToOneBothWayMappingTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Test
	void deleteTest() {
		//user01 회원을 삭제한다.
		userRepository.deleteById("user01");
	}
	
//	@Test
	@Transactional
	void selectTest() {
//		// Many에 해당하는 Board 객체를 검색해서 연관된 User 정보를 사용한다.
//		Board board = boardRepository.findById(1).get();
//		System.out.println(board.getSeq() + "번 게시글 정보");
//		System.out.println("제목 : " + board.getTitle());
//		System.out.println("작성자 : " + board.getUser().getName());
		
		//one에 해당하는 User 객체를 검색해서 연관된 Board 목록을 사용한다.
		User user = userRepository.findById("user01").get();
		System.out.println(user.getName() + "가 등록한 게시글 목록");
		List<Board> boardList = user.getBoardList();
		
		for (Board board : boardList) {
			System.out.println("---> " + board.getSeq() + " : " + board.getTitle());
			
		}
		
		
	}
	
	
	

	//@Test
	void insertTest() {
		// 회원 등록
		User user1 = new User();
		user1.setId("user01");
		user1.setName("둘리");
		userRepository.save(user1);
		
		User user2 = new User();
		user2.setId("user02");
		user2.setName("도우너");
		userRepository.save(user2);
		
		// 게시글 등록
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setTitle("둘리가 등록한 게시글-" + i);
			board.setUser(user1);
			boardRepository.save(board);
		}
		
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setTitle("도우너가 등록한 게시글-" + i);
			board.setUser(user2);
			boardRepository.save(board);
		}
		
	}
}
