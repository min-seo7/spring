package com.example.demo.yedam.service;

import java.util.List;

public interface BookService {
	//전체조회
	List<BookVO> selectBook ();
	//등록 
	int insertBook (BookVO bookVo);
	//대여조회
	List<RentVO> selectRent();
}
