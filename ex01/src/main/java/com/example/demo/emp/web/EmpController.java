package com.example.demo.emp.web;

import java.io.InputStream;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.common.Paging;
import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.service.EmpVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RequestMapping("/emp")  //클래스 레벨에 선언되어 모든 메서드 경로 앞에 자동으로 /emp가 붙음.. 
@Controller
public class EmpController {
	
	@Autowired EmpMapper empService;   //컨트롤러 -> 서비스 -> 매퍼 
	
	
	@GetMapping("/empList")
	public String empList(Model model, EmpVO empVO, Paging paging) {
		paging.setTotalRecord(empService.selectCount(empVO));
		paging.setPageUnit(5);
		empVO.setFirst(paging.getFirst());
		empVO.setLast(paging.getLast());
		model.addAttribute("empList", empService.selectEmp(empVO));
		return "emp/empList"; // html 파일경로
	}
	
	@GetMapping("/emp")
	public String emp(Model model, @RequestParam("employeeId") Long employeeId) {
		model.addAttribute("emp", empService.selectEmpById(employeeId));
		return "emp/emp"; // html 파일경로
	}
	
	@Autowired
	DataSource datasource;
	
	
	@GetMapping("report2")
	public ModelAndView report2() {
		// view 지정
		ModelAndView mv = new ModelAndView(new JasperPdfView("reports/emp.jrxml"));
		
		// 파라미터
		mv.addObject("P_EMPNAME", "hong gildong");
		
		// 데이터 조회
		EmpVO vo = new EmpVO();
		vo.setFirst(1);
		vo.setLast(10);
		mv.addObject("datas", empService.selectEmp(vo));
		
		return mv;
	}
	
	@RequestMapping("report")
	 public void report(HttpServletRequest request, HttpServletResponse response) throws Exception {
	 //Connection conn = datasource.getConnection();
	//소스 컴파일 jrxml -> jasper
	 InputStream jasperStream = getClass().getResourceAsStream("/reports/emp.jrxml");
	 JasperReport jasperReport = (JasperReport) JasperCompileManager.compileReport(jasperStream);
	   
	 //파라미터 맵
	 HashMap<String,Object> map = new HashMap<>();
	 map.put("P_EMPNAME", "HONG GILDONG");
	  
	 //데이터조회
	 EmpVO vo = new EmpVO();
	 vo.setFirst(1);
	 vo.setLast(10);
	 JRDataSource JRdataSource = new JRBeanCollectionDataSource(empService.selectEmp(vo));
	 response.setContentType("application/pdf");
	 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);
	 JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
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