package com.example.demo.security.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.security.service.UserVO;

@Mapper
public interface UserMapper {
	//단건조회
	UserVO getUser(String loginId);
	
	
}
