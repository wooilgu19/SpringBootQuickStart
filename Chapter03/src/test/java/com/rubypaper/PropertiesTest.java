package com.rubypaper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

// @SpringBootTest는 @SpringBootApplication과 동일하게 동작한다.
@SpringBootTest(properties = {"author.nation=KOREA", "author.name=CHAE"})
public class PropertiesTest {
	
//	// properties 파일에 설정한 테스트 데이터를 가져온다.
//	@Value("${author.name}")
//	private String name;
//
//	@Value("${author.age}")
//	private int age;
	
	// @SpringBootTest가 자동 설정 클래스를 실행하여 생성한 Environment 객체를 주입한다.
	@Autowired
	private Environment env;
	
	@Test
	public void testMethod() {
		System.out.println("이름 : " + env.getProperty("author.name"));
		System.out.println("나이 : " + env.getProperty("author.age"));
		System.out.println("나이 : " + env.getProperty("author.nation"));
	}
}
