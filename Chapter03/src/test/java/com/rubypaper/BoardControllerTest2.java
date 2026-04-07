package com.rubypaper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// @WebMvcTest 기능
// 1. Controller 타입(@Controller , @RestController)의 객체만 생성한다. 
// 2. 가짜 서블릿 컨테이너(MockMvc)를 생성한다. (WAS 서버 구동없이...)
@WebMvcTest
public class BoardControllerTest2 {

	// @WebMvcTest가 생성해준 가짜 서블릿 컨테이너를 Mockup한다. 
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testHello() throws Exception {
		//브라우저에서 HTTP 요청(http://localhost:8080/hello.do?name=gurum)을 전송한다.
		mockMvc.perform(get("/hello.do").param("name","gurum"))
		
		// 가짜 서블릿 컨테이너가 전달한 HTTP 응답 메시지를 검증한다. 
		// HTTP 응답 상태 코드가 200번인가?
		.andExpect(status().is(200))
		// HTTP 응답 프로토콜 Body에 실제로 담긴 메시지가 "hello : gurum"인가?
		.andExpect(content().string("hello : gurum"))
		// 테스트 성공시에도 요청/응답 상세 정보를 콘솔에 출력해준다.
		.andDo(print());
	}
}
