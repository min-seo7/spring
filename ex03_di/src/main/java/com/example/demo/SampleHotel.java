package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data 
@Component//빈등록 [의존성 주입을 받는 대상]    => 주입대상 & 주입받는 대상 둘다 빈으로 지정되어야 함. [빈등록 선행, 서로 주입가능]
public class SampleHotel {
	//1. 필드(@Autowired) 2.생성자(@RequireArgConstructor + final) 3.setter (@Stter(onMethod_={@Autowired})
	
	@Autowired
	Chef chef;
}
