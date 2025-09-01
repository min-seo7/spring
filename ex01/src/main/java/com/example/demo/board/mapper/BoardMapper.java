package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.service.BoardVO;
import com.example.demo.board.service.ReplyVO;

@Mapper
public interface BoardMapper {
	// 건수조회
	Long selectCount(BoardVO boardVO);
	
	// 전체조회
	List<BoardVO> selectBoard(BoardVO boardVO);
	
	// 단건조회
	List<ReplyVO> selectBoardByBno(Long bno);
}