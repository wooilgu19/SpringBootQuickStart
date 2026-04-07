package com.rubypaper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rubypaper.jdbc.ConnectionManager;

//@Configuration도 @Conponent를 포함하기 때문에 @ComponentScan에 의해 자동 생성된다.
@Configuration
public class BoardConfiguration {
	public BoardConfiguration() {
		System.out.println("---> BoardConfiguration 생성");
	}
	
//	//BoardAutoConfiguration이 생성한 ConnectionManager를 재정의(Override)한다
//	@Bean
//	ConnectionManager connectionManager() {
//		ConnectionManager manager = new ConnectionManager();
//		manager.setDriverClass("org.h2.Driver");
//		manager.setUrl("jdbc:h2:tcp://localhost/~/test");
//		manager.setUsername("sa");
//		manager.setPassword("");
//		return manager;
//	}
}
