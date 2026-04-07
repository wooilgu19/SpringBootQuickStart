package com.rubypaper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.nullable;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rubypaper.junit.MyCalc;

class MyCalcTest {
	private MyCalc calc;

//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//		System.out.println("---> setUpBeforeClass()");
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//		System.out.println("---> tearDownAfterClass()");
//	}

	@BeforeEach
	void 사전처리() throws Exception {
		System.out.println("---> 사전처리()");
		calc = new MyCalc(10, 3);
	}

	@AfterEach
	void 사후처리() throws Exception {
		System.out.println("---> 사후처리()");
		calc = null;
	}

	@Test
	void plus테스트() {
		System.out.println("===> plus테스트()");
		assertEquals(13, calc.plus());
	}

	@Test
	void minus테스트() {
		System.out.println("===> minus테스트()");
		assertEquals(8, calc.minus());
	}

}
