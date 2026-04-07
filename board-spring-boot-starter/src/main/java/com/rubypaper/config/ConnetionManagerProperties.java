package com.rubypaper.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

// application.properties 파일에서 board.datasource로 시작하는 프로퍼티 정보를 읽어서
// ConnetcionManagerProperties 객체의 맴버변수를 초기화해라. ( setXXX 메소드 자동 호출 )
@ConfigurationProperties(prefix = "board.datasource")
public class ConnetionManagerProperties {
	private String driverClass;
	private String url;
	private String username;
	private String password;
	
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
}
