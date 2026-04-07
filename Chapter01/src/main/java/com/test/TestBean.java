package com.test;

import org.springframework.stereotype.Component;

@Component
public class TestBean {
	public TestBean() {
		System.out.println("---> TestBean 생성");
	}
}
