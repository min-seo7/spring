package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyVO;

@SpringBootTest
public class ReplyMapperTest {
	
	@Autowired ReplyMapper replyMapper;
	
	//게시글의 댓글 목록 조회
	@Test
	public void getList() {
		//given
		ReplyVO reply = new ReplyVO();
		
		reply.setBno(1L);
		reply.setFirst(1);
		reply.setLast(10);
		//when
		List<ReplyVO> list= replyMapper.getList(reply);
		
		//then
		//두개 동일한 문법. 축약형.
		list.forEach(System.out::println);  
		//list.forEach(reply -> System.out.println(reply));
	}
	
	//댓글등록 테스트
	//@Test
	public void insert() {
		//given
		ReplyVO reply = new ReplyVO();
		
		reply.setBno(1L);
		reply.setReplyer("hoon");
		reply.setReply("재밌어용!");
		//when
		int result = replyMapper.insert(reply);
		//then
		assertEquals(result, 1);
	}
	
}
