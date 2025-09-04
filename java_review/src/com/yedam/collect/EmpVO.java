package com.yedam.collect;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpVO {
	//필드선언
	private int empno;   //final필드는 초기화가 필수!롬복 Data로 해결가능함. 
	private String ename;
	private int dept;
		
}
