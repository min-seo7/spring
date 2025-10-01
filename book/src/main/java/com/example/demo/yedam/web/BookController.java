package com.example.demo.yedam.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.yedam.service.BookService;
import com.example.demo.yedam.service.BookVO;
import com.example.demo.yedam.service.RentVO;

@Controller
public class BookController {
	
	@Autowired BookService bookservice;
	
	@GetMapping("home")
	public String mainPage() {
		return "home";
	}
	
	//목록조회
	@GetMapping("booklist")
	public String bookList (Model model, BookVO bookVo) {
		model.addAttribute("bookList", bookservice.selectBook());
		return "list";
	}
	
	
	//등록
	//1)등록페이지 이동
	@GetMapping("register")
	public String registerPage() {
		return "register";
	}
	
	//2)등록처리
	@ResponseBody
	@PostMapping("register")
	public String Book(@RequestBody BookVO bookVO) {
		bookservice.insertBook(bookVO);
		return "true";
	}
	
	//대여목록
	@GetMapping("rentlist")
	public String RentList(Model model, RentVO rentVo) {
		model.addAttribute("rentList", bookservice.selectRent());
		return "rentlist";
	}
	
	
}
