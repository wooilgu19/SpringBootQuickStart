package com.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
// 메인 클래스를 환경설정 클래스로 만드는 설정
@Configuration

// 스프링 부트가 제공하는 자동 설정 클래스(Auto Configuration)들을 로딩한다.
@EnableAutoConfiguration

// 사용자가 작성한 클래스들(@Controller, @Service, @Repository)의 객체를 생성한다.
@ComponentScan(basePackages = {"com.rubypaper"})
public class Chapter02Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter02Application.class, args);
	}

}
