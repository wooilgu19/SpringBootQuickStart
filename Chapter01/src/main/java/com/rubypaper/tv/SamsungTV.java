package com.rubypaper.tv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV {
	
	//메모리에서 Speaker 타입의 객체를 찾아서 speaker 변수에 주입해라.
	@Autowired
	private Speaker speaker;
	
	public SamsungTV() {
		System.out.println("---> SamsungTV 생성");
	}
	
//	public void setSpeaker(Speaker speaker) {
//		this.speaker = speaker;
//	}

	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다.");
	}
	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
}
