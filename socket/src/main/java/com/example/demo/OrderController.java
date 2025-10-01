package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
		
	@Autowired
	SimpMessagingTemplate template;
	
	@ResponseBody
	@GetMapping("/order")
	public String order() {
		//1) 서비스:주문등록 데이터 insert
		
		//2) 메세지 보내기(영업부 직원에게 메세지전송)
		this.template.convertAndSend("/topic/greetings", new Greeting("order", "거래처 주문등록"));
		
		return "success";
	}
}
