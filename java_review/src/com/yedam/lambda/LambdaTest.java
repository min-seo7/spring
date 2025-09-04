package com.yedam.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.yedam.collect.EmpVO;

class NameComp implements Comparator<EmpVO> {

	@Override
	public int compare(EmpVO o1, EmpVO o2) {
		return o1.getDept() - o2.getDept();
	}

}


public class LambdaTest {

	//@Test
	public void test1() {
		List<EmpVO> list = Arrays.asList(
				         new EmpVO(100, "홍길동", 10),
				         new EmpVO(101, "박길동", 50),
				         new EmpVO(102, "lee길동",30),
				         new EmpVO(103, "최길동", 20)
				);
			
		list.sort(new NameComp()); 
		System.out.println(list);
	}
	
	
	
	//@Test
	public void test2() {
		List<EmpVO> list = Arrays.asList(
				         new EmpVO(100, "홍길동", 10),
				         new EmpVO(101, "박길동", 50),
				         new EmpVO(102, "lee길동",30),
				         new EmpVO(103, "최길동", 20)
				);
			
		list.sort(new Comparator<EmpVO>() {
			@Override
			public int compare(EmpVO o1, EmpVO o2) {
				return o2.getEmpno() - o1.getEmpno();
			}});//익명클래스 
		System.out.println(list);
	}
	
	@Test
	public void test3() {
		List<EmpVO> list = Arrays.asList(
				         new EmpVO(100, "홍길동", 10),
				         new EmpVO(101, "박길동", 50),
				         new EmpVO(102, "lee길동",30),
				         new EmpVO(103, "최길동", 20)
				);
		//익명클래스 + 람다식 sorting(추상메서드가 하나인 경우) 	
		list.sort((EmpVO o1, EmpVO o2 ) ->  o2.getEmpno() - o1.getEmpno());  
		System.out.println(list);
	}
}
