package com.example.demo;

import org.springframework.stereotype.Component;
@Component  //싱글톤 패턴 객체를 생성해서 컨테이너 담기
public class Cat implements Animal {

	@Override
	public void sound() {
		System.out.println("야옹!");
	}

}
