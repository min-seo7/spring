package com.example.demo;

import org.springframework.stereotype.Component;

//@Component
public class LgTV implements TV {  //삼성과 LG의 소리함수가 각각 다른 이름으로정 의됨. 

	public void powerOn() {
		System.out.println("LG TV--전원 on");
	}
	public void powerOff() {
		System.out.println("LG TV--전원 off");
	}
	public void volumeUp() {
		System.out.println("LG TV--볼륨 up");
	}
	public void volumeDown() {
		System.out.println("LG TV--볼륨 down");
	}
}

