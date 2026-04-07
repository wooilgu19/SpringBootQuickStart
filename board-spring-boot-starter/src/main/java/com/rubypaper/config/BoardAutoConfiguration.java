package com.rubypaper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rubypaper.jdbc.ConnectionManager;

//@EnableAutoConfiguration이 자동으로 생성할 환경 설정 클래스
@Configuration
// ConnetionManagerProperties 객체를 생성해라.
@EnableConfigurationProperties(ConnetionManagerProperties.class)
public class BoardAutoConfiguration {
	
	// ConnetionManagerProperties 객체를 properties 변수에 주입해라.
	@Autowired
	private ConnetionManagerProperties properties;
	
	public BoardAutoConfiguration() {
		System.out.println("---> BoardAutoConfiguration 생성");
	}
	
	@Bean
	// 메모리에 ConnectionManager 객체가 없다면 ... connectionManager()메소드를 실행해라.
	@ConditionalOnMissingBean//(ConnectionManager.class)
	ConnectionManager connectionManager() {
		ConnectionManager manager = new ConnectionManager();
		manager.setDriverClass(properties.getDriverClass());
		manager.setUrl(properties.getUrl());
		manager.setUsername(properties.getUsername());
		manager.setPassword(properties.getPassword());
		return manager;
		
	}

}
