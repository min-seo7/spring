package com.example.demo.ex1;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

/*
 *어노테이션 활용해서 form 입력값 유효성 체크. [별도의 함수생성 필요없음!] 
 */

@Controller
public class PersonController {
	
	@GetMapping("/person")
	public String showForm(PersonForm personForm) {
		return "form";   //리턴값은 html이름과 동일해야 함. 
	}

	@PostMapping("/person")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {   //유효성 체크해서 에러가 있으면 폼으로 돌아감. 
			return "form";
		}

		return "redirect:/api/sample";
	}
}
