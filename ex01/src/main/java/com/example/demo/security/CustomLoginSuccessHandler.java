package com.example.demo.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.security.service.CustomUserDetail;
import com.example.demo.security.service.UserVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//WebSecurityConfig에서 bean등록해줌. 
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
			                 HttpServletResponse response,
			                 Authentication auth) throws IOException, ServletException {
		//단건조회
		UserVO dto = ((CustomUserDetail)auth.getPrincipal()).getUserVO();
		
		//session
		request.getSession().setAttribute("userid", dto.getId());
		request.getSession().setAttribute("deptName", dto.getDeptName());
		
		//username, role
		List<String> roleNames = new ArrayList<>();		  //여러개 role이 가능해서 list로 받음. 
		auth.getAuthorities().forEach( authority -> { 
			roleNames.add( authority.getAuthority());
		}  );		
		System.out.println("roleName:" + roleNames);
		
		if ( roleNames.contains("ROLE_ADMIN") ) {  //admin일 경우 /admin이동
			response.sendRedirect("/emp/empList");
			return;
		} else if ( roleNames.contains("ROLE_USER") ) {
			response.sendRedirect("/boardList");
			return;
		} 
		response.sendRedirect("/");
	}

}