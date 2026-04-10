package com.rubypaper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
// @EnableWebSecurity : 이제부터 스프링 시큐리티를 커스터마이징 하겠다는 선언이다.
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	private UserDetailsService detailsService;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		// CSRF 토큰 비활성화
		security.csrf(csrf -> csrf.disable());
		
		// 인증/인가 설정
		security.authorizeHttpRequests(authorize -> authorize
				// 요청 url에 /member/ 경로가 포함된 모든 요청은 인증을 해야한다.
				.requestMatchers("/member/**").authenticated()
				.requestMatchers("/manager/**").hasRole("MANAGER")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().permitAll());
		
		// 로그인 설정
		security.formLogin(login -> login
				.loginPage("/login")
				.defaultSuccessUrl("/success", true)); // 로그인 성공시, 이동할 화면 설정
		
		// 권한 에러 페이지 설정
		security.exceptionHandling(exception -> exception
				.accessDeniedPage("/denied"));
		
		// 로그아웃 설정
		security.logout(logout -> logout
				.invalidateHttpSession(true) // 세션 강제 종료
				.logoutSuccessUrl("/"));	 // 로그아웃 성공 시, 이동할 페이지 지정
		
		// 사용자 정의 UserDetailsServce 적용
		security.userDetailsService(detailsService);
		
		return security.build();
	}
}





