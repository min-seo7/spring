package com.example.demo.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

/*
 * Spring Security가 인식할 수 있는 사용자 정보
 */

@Data
public class CustomUserDetail implements UserDetails {

	UserVO userVO;   //UserVO자체를 injection 후 필드를 꺼내씀.
	
	public CustomUserDetail(UserVO userVO) {  //생성자
		super();
		this.userVO = userVO;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();
		userVO.getRoles().forEach(role -> list.add(new SimpleGrantedAuthority(role.getRoleName()) ));
		return list;
	}

	@Override
	public String getPassword() {
		return userVO.getPassword();
	}

	@Override
	public String getUsername() {
		return userVO.getFullName();
	}

}
