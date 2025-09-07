package com.example.demo.security;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * 접근거부 핸들러
 */

//WebSecurityConfig 여기서 빈 등록함. 
public class CustomAccessDeniedHandler implements AccessDeniedHandler{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		//response.sendRedirect(""); //이동페이지 경로 넣어주면됨 (컨트롤러)
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().append("<script>")
		                    .append("alert('접근오류 권한이 없습니다.');")
		                    .append("location.href='/';")
		                    .append("</script>");
	}
	
}
