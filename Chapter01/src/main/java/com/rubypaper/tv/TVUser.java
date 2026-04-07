package com.rubypaper.tv;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		// 1. spring 컨테이너를 생성한다. 
//		GenericXmlApplicationContext container = 
//				new GenericXmlApplicationContext("context.xml");
		
//      //AnotationConfigApplicationContext는 환경설정 클래스를 로딩하여 구동되는 컨테이너다.		
//		AnnotationConfigApplicationContext container = 
//				new AnnotationConfigApplicationContext(TVConfiguration.class);
		
		//com.rubypaper 패키지 밑에 @Component가 붙은 클래스들을 찾아 객체 생성해라.
		AnnotationConfigApplicationContext container = 
				new AnnotationConfigApplicationContext("com.rubypaper");
		
		// 2. Spring 컨테이너가 생성한 객체를 look up 해서 사용한다.
		
		TV tv = (TV) container.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		//3. spring 컨테이너를 종료한다. 
		container.close();
	}

}
