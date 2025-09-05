package com.example.demo.board.service;

import java.util.List;

import com.example.demo.board.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

public interface BoardService {
	
	    // 건수조회
		Long selectCount(BoardVO boardVO);
		// 전체조회
		List<BoardVO> selectBoard(BoardVO boardVO);
		// 게시글 단건조회
		BoardVO selectBoardByBno(Long bno);
		//등록
		int insertBoard(BoardVO boardVO);
		//댓글조회
		List<ReplyVO> selectReply(Long bno);
		//삭제
		int deleteBoard(Long bno);
		
}
