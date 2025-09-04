package com.example.demo.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserVO {
	  private Long id;
	  private String loginId;
	  private String password;
	  private String fullName;
	  private String deptName;
	  
	  private List<RoleVO> roles;

}