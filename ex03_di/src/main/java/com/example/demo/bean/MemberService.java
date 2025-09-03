package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class MemberService {
	
	MemberMapper memberMapper; //@(어노테이션)없이 빈 등록 
	
	public void print() {
		System.out.println(memberMapper + "서비스 호출");
	}
}
