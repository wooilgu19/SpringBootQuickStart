package com.rubypaper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.rubypaper.domain.BoardVO;

// @SpringBootTest 기능
// 1. 모든 유형의 객체들을 생성한다.
// 2. @SpringBootTest의 webEnvironment 속성을 이용하면 Tomcat 서버를 구동할 수 있다.
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT) // 랜덤 포트로 서버 구동
public class BoardControllerTest3 {
	
	// TestRestTemplate 객체는 가짜 웹브라우저다.(Spring Boot 4.0.5에서 충돌난다.)
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void testHello() throws Exception {
		String result = restTemplate.getForObject("/hello.do?name=gurum", String.class);
		assertEquals("hello : gurum", result);
	}
	
	@Test
	void testGetBoard() throws Exception {
		BoardVO result = restTemplate.getForObject("/getBoard.do", BoardVO.class);
		// BoardController.getBoard()가 뭔가를 리턴했는지 검증한다.
		assertNotNull(result);
		// 리턴된 값을 확인한다.
		assertEquals("테스터", result.getWriter());
	}
	
	@Test
	void testGetBoardList() throws Exception {
		List result = restTemplate.getForObject("/getBoardList.do", List.class);
		// 리턴된 값을 확인한다.
		assertEquals(5, result.size());
	}

}





