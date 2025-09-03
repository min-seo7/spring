package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DITest {
	
	@Autowired TV tv;  //인터페이스를 implemnts한 class 다 주입.
	@Autowired SampleHotel hotel;
	
	//@Test
	public void test() {  
		//TV tv = new SamusingTV();  @Component 지정한 클래스를 객체생성없이 사용가능함. 
		//1) interface로 메서드표준정의. 
		//2)import받는 클래스들에 @Component 지정. 
		//3)컴포넌트 활성화 비활성화로 객체생성으로 바로 사용가능.[LGtv & t삼성TV 참고]
		tv.powerOn();
		tv.volumeUp();
	}
	
	@Test
	public void hotel_test() {
		System.out.println(hotel.getChef());
	}
}
