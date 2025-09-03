package com.example.demo;

import java.util.Date;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Lazy  //지연전달(지연로딩)
@Scope("singleton")
@Component
//@AllArgsConstructor 전부 다 주입받고
@RequiredArgsConstructor  //선택해서 주입받음 final지정은 필수로 지정됨. 
public class SamsungTV implements TV {  //우클릭 - refactor- extract Interface (표준/인터페이스 자동생성.)

	/*주입방식 3가지 
	//1) @Autowired 
	Speaker speaker;  //interface Speaker 주입받음. //삼성tv는 스피커랑 의존관계가 됨.
	
	//2) 생성자 주입방식 !!!권장방식 => lombock 사용하면됨.. 다 노필요! 
	public SamsungTV(Speaker speaker) {
	this.speaker = speaker;
    }
	
	//3) setter사용 주입방식(autowired필수)
	@Autowired
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	//99)세터메서드드를 만들때 Autowiered도 생상요청지정.. 
	@Setter(onMethod_ = {@Autowired}
	Speaker speaker;
	
	==> 롬복으로 2)번방식 한번에 처리하면 됨. (하단참고)
*/	
	final Speaker speaker;  //@AllArgsConstructor로 추해주면 주입됨.
	Date date;
	
	@Override
	public void powerOn() {
		System.out.println("삼성 TV--전원 on");
	}
	@Override
	public void powerOff() {
		System.out.println("삼성 TV--전원 off");
	}
	@Override
	public void volumeUp() {
		speaker.volumeUp(); //삼성tv는 스피커랑 의존관계가 됨. interface는 메소드 정의가 안되어 있으니 메소드 정의된 객체도 컴포넌트 등록해줘야함(애플스피커, 소니스피커)
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();  //삼성tv는 스피커랑 의존관계가 됨.
	}
}
