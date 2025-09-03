package com.example.demo.board.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;
import com.example.demo.board.service.ReplyVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

	//서비스구현은 mapper를 injection해줘야함
    final BoardMapper boardMapper;
	
	@Override
	public Long selectCount(BoardVO boardVO) {
		return boardMapper.selectCount(boardVO);
	}

	@Override
	public List<BoardVO> selectBoard(BoardVO boardVO) {
		return boardMapper.selectBoard(boardVO);
	}

	@Override
	public BoardVO selectBoardByBno(Long bno) {
		return boardMapper.selectBoardByBno(bno);
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		return boardMapper.insertBoard(boardVO);
	}

	@Override
	public List<ReplyVO> selectReply(Long bno) {
		return boardMapper.selectReply(bno);
	}

}
