package com.rubypaper.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class LoggingService implements ApplicationRunner {

	// LoggingService 클래스가 속한 패키지에 해당하는 로거 객체를 획득한다.
	private Logger logger = LoggerFactory.getLogger(LoggingService.class);
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// 로거 객체를 이용하여 다양한 레벨의 로그를 출력한다.
		logger.trace("---TRACE 레벨의 로그");
		logger.debug("---DEBUG 레벨의 로그");
		logger.info("---INFO 레벨의 로그");
		logger.warn("---WARN 레벨의 로그");
		logger.error("---ERROR 레벨의 로그");

	}

}
