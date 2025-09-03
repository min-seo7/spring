package com.example.demo.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;
import com.example.demo.common.Paging;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;   //서비스(interface) 주입
	
	@GetMapping("boardList")
	public String BoardList(Model model, BoardVO boardVO, Paging paging) {
		paging.setTotalRecord(boardService.selectCount(boardVO));
		paging.setPageUnit(5);
		boardVO.setFirst(paging.getFirst());
		boardVO.setLast(paging.getLast());
		                 // (View 지정,  DB 결과 (인터페이스 -> mapper.xml SQL 실행))
		model.addAttribute("boardList", boardService.selectBoard(boardVO));
		return "boardList";  // View에 전달
	}
	
	@GetMapping("board")
	public String Board(Model model, @RequestParam("bno") Long bno) {
		model.addAttribute("board", boardService.selectBoardByBno(bno));  // 단일 게시글
		model.addAttribute("replyList", boardService.selectReply(bno)); // 댓글 리스트
		return "board";
	
	}
	
}