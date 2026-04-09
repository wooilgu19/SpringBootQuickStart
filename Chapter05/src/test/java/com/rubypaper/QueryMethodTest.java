package com.rubypaper;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@SpringBootTest
public class QueryMethodTest {

	@Autowired
	private BoardRepository boardRepository;
	
	@Test
	void getBoardList() {
		Pageable pageable = PageRequest.of(0, 5);
		List<Object[]> boardList = boardRepository.getBoardListBySQL("17", pageable);
		
		System.out.println("[ 검색 결과] ");
		for (Object[] board : boardList) {
			System.out.println("---> " + Arrays.toString(board));
		}
	}
	
//	@Test
//	void getBoardList() {
//		Pageable pageable = PageRequest.of(0, 5);
//		List<Object[]> boardList = boardRepository.getBoardListByJPQL("17", pageable);
//		
//		System.out.println("[ 검색 결과] ");
//		for (Object[] board : boardList) {
//			System.out.println("---> " + Arrays.toString(board));
//		}
//	}

//	@Test
//	void getBoardList() {
//		Pageable pageable = PageRequest.of(1, 10); // 1페이지에 해당하는 10건의 데이터를 가져와라
//		Page<Board> pageInfo = boardRepository.findByTitleContaining("목-13", pageable);
//		
//		System.out.println("[ 검색 결과] ");
//		List<Board> boardList = pageInfo.getContent();
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//		
//		System.out.println("검색된 전체 데이터 수 : " + pageInfo.getTotalElements());
//		System.out.println("전체 페이지 수 : " + pageInfo.getTotalPages());
//		System.out.println("페이지 당 출력되는 데이터 수 : " + pageInfo.getSize());
//		
//		if(pageInfo.hasPrevious()) {
//			System.out.println("이전 페이지 정보 : " + pageInfo.previousPageable());
//		}
//		System.out.println("현재 페이지 정보 : " + pageInfo.getPageable());
//		if(pageInfo.hasNext()) {
//			System.out.println("다음 페이지 정보 : " + pageInfo.nextPageable());
//		}
//	}
	
	@BeforeEach // @Test 메소드가 실행되기 전에 동작한다.
	void dataInit() {
		// 테스트에 필요한 데이터를 설정한다.
		for (int i = 1; i <= 200; i++) {
			Board board = new Board();
			board.setTitle("테스트 제목-" + i);
			board.setWriter("테스터");
			board.setContent("테스트 내용-" + i);
			board.setRegDate(new Date());
			board.setCnt(0);
			boardRepository.save(board);
		}
	}
}







