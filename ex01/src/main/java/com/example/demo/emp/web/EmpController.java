package com.example.demo.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.common.Paging;
import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.service.EmpVO;

@Controller
public class EmpController {
	
	@Autowired EmpMapper empService;   //컨트롤러 -> 서비스 -> 매퍼 
	
	
	@GetMapping("empList")
	public String empList(Model model, EmpVO empVO, Paging paging) {
		paging.setTotalRecord(empService.selectCount(empVO));
		paging.setPageUnit(5);
		empVO.setFirst(paging.getFirst());
		empVO.setLast(paging.getLast());
		model.addAttribute("empList", empService.selectEmp(empVO));
		return "empList"; // empList.html
	}
	
	@GetMapping("emp")
	public String emp(Model model, @RequestParam("employeeId") Long employeeId) {
		model.addAttribute("emp", empService.selectEmpById(employeeId));
		return "emp"; // emp.html
	}
	
	//컨트롤러 -> 매퍼 방식 
	//@Autowired EmpMapper empMapper; // new X, 객체(빈)가 주입됨  => 컨트롤러가 바로 매퍼를 주입하는 방식(현업에서는 사용xxxxxxx)
	
//	@GetMapping("empList")
//	public String empList(Model model, EmpVO empVO, Paging paging) {  
//		paging.setTotalRecord(empMapper.selectCount(empVO));
//		paging.setPageUnit(5);
//		empVO.setFirst(paging.getFirst());
//		empVO.setLast(paging.getLast());
//		model.addAttribute("empList", empMapper.selectEmp(empVO));
//		return "empList"; // empList.html
//	}
//	
//	@GetMapping("emp")
//	public String emp(Model model, @RequestParam("employeeId") Long employeeId) {
//		model.addAttribute("emp", empMapper.selectEmpById(employeeId));
//		return "emp"; // emp.html
//	}
}