package com.example.demo.security.service;

import java.util.List;

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