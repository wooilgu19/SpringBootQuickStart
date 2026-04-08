package com.rubypaper.junit;

public class MyCalc {
	private int x;
	private int y;
	
	public MyCalc(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int plus() {
		return x + y;
	}
	
	public int minus() {
		return x - y;
	}

}
