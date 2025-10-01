package com.example.demo.yedam.service.impl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.yedam.service.BookService;
import com.example.demo.yedam.service.BookVO;
import com.example.demo.yedam.service.RentVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService{

	final Bookmapper bookMapper;
	
	@Override
	public List<BookVO> selectBook() {
		return bookMapper.selectBook() ;
	}

	@Override
	public int insertBook(BookVO bookVo) {
		return bookMapper.insertBook(bookVo);
	}

	@Override
	public List<RentVO> selectRent() {
		return bookMapper.selectRent();
	}

}
