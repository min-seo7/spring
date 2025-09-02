package com.example.demo.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyVO;

@RestController   //비동기 방식
public class ReplyController {
	
	@Autowired ReplyMapper replyMapper;
	
	//등록
	@PostMapping("/reply")
	public int insert(@RequestBody ReplyVO reply) {
		int result = replyMapper.insert(reply);
		return result;
	}
	
	//수정
	@PutMapping("/reply/{rno}")
	public String update() {
		return "";
	}
	
	//삭제
	@PostMapping("/reply/{rno}")
	public String delete() {
		return "";
		}
	
	//전체조회
	@GetMapping("/board/{bno}/reply")
	public String list() {
		return "";
	}
	
	//단건조회
	@GetMapping("/reply/{rno}")
	public String get() {
		return "";
	}
}
