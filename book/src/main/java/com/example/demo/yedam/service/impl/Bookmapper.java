package com.example.demo.yedam.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.yedam.service.BookVO;
import com.example.demo.yedam.service.RentVO;

@Mapper
public interface Bookmapper {
	//전체조회
	List<BookVO> selectBook ();
	//등록 
	int insertBook (BookVO bookVo);
	//대여조회
	List<RentVO> selectRent();
}
