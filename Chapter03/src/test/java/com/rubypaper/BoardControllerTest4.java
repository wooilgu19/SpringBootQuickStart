package com.rubypaper;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.h2.command.dml.MergeUsing.When;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.rubypaper.service.BoardService;

// @WebMvcTest 기능
// 1. Controller 타입(@Controller, @RestController)의 객체만 생성한다.
// 2. 가짜 서블릿 컨테이너(MockMvc)를 생성한다.(WAS 서버 구동 없이...)
@WebMvcTest
public class BoardControllerTest4 {
	
	// @WebMvcTest가 생성해준 가짜 서블릿 컨테이너를 Mockup한다.
	@Autowired
	private MockMvc mockMvc;
	
	// BoardService 인터페이스를 구현한 객체를 생성하고 ( Mocking ) 주입해라(Mockup).
	@MockitoBean
	private BoardService boardService;
	
	@Test
	public void testHello() throws Exception {
		// 가짜 비지니스 객체의 메소드를 추출한다. 
		when(boardService.hello("gurum"))
		.thenReturn("hello : gurum");
		
		//가짜 서블릿 컨테이너(MockMvc)를 이용하여 컨트롤러를 테스트한다.
		mockMvc.perform(get("/hello.do").param("name","gurum"))
		.andExpect(status().is(200))
		.andExpect(content().string("hello : gurum"));
	}
	
	@Test
	public void testGetBoard() throws Exception {
		
		Map<String, Object> board = new HashMap<>();
		
		board.put("seq", 1);
		board.put("title", "테스트 제목");
		board.put("writer", "테스터");
		
		//가짜 비즈니스 객체의 메소드를 호출한다. 
		when(boardService.getBoard(1))
		.thenReturn(board);
		
	
		
		//가짜 서블릿 컨테이너(MockMvc)를 이용하여 컨트롤러를 테스트한다.
		mockMvc.perform(get("/getBoard.do").param("seq","1"))
		.andExpect(status().is(200))
		.andExpect(jsonPath("$.writer").isNotEmpty())
		.andExpect(jsonPath("$.writer").value("테스터"))
		.andDo(print());
	
	}


}





