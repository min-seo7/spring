package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class HomeController {

	@Autowired 
	Animal animal;  
	
	@GetMapping("/")
	@ResponseBody
	public String home() {
		animal.sound();
		return "hello";  //json
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";   //templates(폴더(/main.html로 
	}
	
}
