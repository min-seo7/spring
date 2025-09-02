package com.example.demo.ex1;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/api")
@Controller
public class Ex1Controller {
	
	
	@GetMapping("/sample")  //void경우, templates/api/main.html와 GetMapping("/main") 매핑된 이름과 동일할떄,생략가능
	public ModelAndView sample() {
		ModelAndView mv = new ModelAndView("sample");
		mv.addObject("today", new Date());
		return mv;
	}
		
	@GetMapping("/main")  //void경우, templates/api/main.html와 GetMapping("/main") 매핑된 이름과 동일할떄,생략가능
	public void main() {}
	
	
	//커맨드 객체만 적어주면 자동으로 매핑. but 넘겨주는 변수랑 VO필드명이 일치
	@GetMapping("/ex1")
	public String ex1(@ModelAttribute("user") UserVO userVO, Model model) {
		//model.addAttribute("user", userVO);
		log.info(userVO);
		return "sample";
	}
	
	//인덱스 배열객체	
	@GetMapping("/ex2") //userList[0].name?
	public String ex2(UserListVO list) {
		log.info(list);
		return "sample";
	}
	
	//request.getParameter()사용이랑 동일. 파라미터로 개별로 받아올 수 있음.(원시 데이터형 String, int등등) 하나씩 받음
	@GetMapping("/ex3") //required = false-> 필수입력 안해도 되는걸로// defaultValue = "20" 디폴트값 지정// value =""는 뷰에서 넘겨주는 파라미터 이름이 다를때 지정
	public String ex3(@RequestParam String name, @RequestParam(value = "userage", required = false, defaultValue = "20") Integer age) {
		log.info(name + " : " + age);
		return "sample";
	}
	
	//Map <-모든 파라미터를 map으로 묶어서 받을 수 있음.
	@GetMapping("/ex4")
	public String ex4(@RequestParam Map<String, Object> map) {
		log.info(map);
		return "sample";
	}
	
	//url상에서 ex5?name=홍길동&age=20방식으로 사용xx, 값만 보내는 방식.
	@GetMapping("/ex5/{name}/{age}")  //http://localhost/api/ex5/kim/20
	public String ex5(@PathVariable String name, @PathVariable int age) {
		log.info("path=" + name + " : " + age);
		return "sample";
	}
	
	//첨부파일
	@PostMapping("/ex6")
	public String ex6(UserVO vo, MultipartFile pic) {
		log.info(pic.getOriginalFilename());
		log.info(pic.getSize());
		log.info(vo);
		return "sample";
    }
}
