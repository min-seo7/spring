package com.yedam.collect;

import lombok.Builder;
import lombok.Data;

@Data
public class EmpVO {
	//필드선언
	final private int empno;   //final필드는 초기화가 필수!롬복 Data로 해결가능함. 
	final private String ename;
	private String dept;
		
}
