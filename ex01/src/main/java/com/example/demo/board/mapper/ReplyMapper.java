package com.example.demo.board.mapper;

import java.util.List;

import com.example.demo.board.service.ReplyVO;

public interface ReplyMapper {
	//등록
	int insert(ReplyVO reply);
	//단건조회
	ReplyVO read (Long rno);
	//삭제
	int delete (Long rno);
	//수정
	int update(ReplyVO reply);  //ReplyVO에 rno있음.
	//댓글리스트
	List<ReplyVO> getList(ReplyVO reply);  //페이징으로 인해 replyMapper.xml에 보면 전달해야할 값이 3개임. VO처리하기로 함.
	//건수조회
	Long getCountByBno(Long bno);
}
