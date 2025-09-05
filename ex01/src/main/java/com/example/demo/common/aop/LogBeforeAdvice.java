package com.example.demo.common.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//로그관련
@Aspect    // Aspect 클래스로 정의. Aspect란? 핵심 로직 외의 공통 기능 (예: 로깅, 보안, 트랜잭션) 을 모듈화한 것입
@Component    //필수임
public class LogBeforeAdvice {
	
	@Pointcut("execution(* com.example..*Impl.*(..))")   
	public void allpointcut() {}
		
	@Before ("allpointcut()")   //aspect로 import해야함.
	public void print() {
		System.out.println("[bafore] 로그 실행");
	}
}
