package com.example.demo.security.service.Impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.security.mapper.UserMapper;
import com.example.demo.security.service.CustomUserDetail;
import com.example.demo.security.service.UserService;
import com.example.demo.security.service.UserVO;

import lombok.RequiredArgsConstructor;


/*
 * 로그인 시 DB에서 유저를 꺼내오는 로직 [메퍼(interface)를 주입해줘야함.]
 */

@RequiredArgsConstructor //메퍼주입
@Service  //빈등록
public class UserServiceImpl implements UserService, UserDetailsService {

	final UserMapper userMapper;
	
	@Override
	public UserVO getUser(String loginId) {
		return userMapper.getUser(loginId);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO userVO = userMapper.getUser(username);
		
		if(userVO == null) {
			throw new UsernameNotFoundException("not found id");
		}
		
		return new CustomUserDetail(userVO);
	}

}
