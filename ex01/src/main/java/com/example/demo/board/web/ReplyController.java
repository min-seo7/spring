package com.example.demo.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public int insert(@RequestBody ReplyVO reply) {  //@RequestBody는 요청 본문(JSON)을 자바 객체(ReplyVO)로 바꿔주는 역할
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
	
	//전체조회(해당 게시글의 전체 댓글목록 조회)
	@GetMapping("/board/{bno}/reply")
	public List<ReplyVO> list(@PathVariable Long bno, ReplyVO vo) {  //@PathVariable Long bno를 통해 URL의 {bno} 값이 메서드 파라미터로 들어옴.
		vo.setBno(bno);
		vo.setFirst(1);
		vo.setLast(100);
		return replyMapper.getList(vo);
	}
	
	//단건조회
	@GetMapping("/reply/{rno}")
	public String get() {
		return "";
	}
}
