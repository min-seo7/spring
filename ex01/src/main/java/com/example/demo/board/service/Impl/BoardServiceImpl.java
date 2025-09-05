package com.example.demo.board.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;
import com.example.demo.board.service.ReplyVO;
import com.example.demo.common.aop.PrintExecutionTime;

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
	@PrintExecutionTime  //게시글 목록출력시 실행시간을 별도의 aop로 만듬. aop패키지 확인!  
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

	@Transactional  //트랜잭션: 하나의 업무단위
	@Override  //게시글 삭제시 + 댓글삭제 + 첨부파일 삭제 [3개의 작업이 발생해야 함!]
	public int deleteBoard(Long bno) {
		//댓글삭제
		
		//첨부파일 삭제
		
		//게시글 삭제
		
		return 0;
	}

	
}
