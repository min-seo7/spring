package com.example.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.domain.Posts;
import com.example.demo.repository.PostsRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class PostsRepositoryTest {
	
	@Autowired PostsRepository postRepository;
	
	@Transactional
	@Rollback(true) 
	@Test
	public void insert() {
		//1) 생성자 사용
		//Posts posts = new Posts("", "", ""); 생성자로 바로 생성방식 
		//2) builder 사용 => 생성자방식은 순서를 지켜줘야하지만, builder방식은 순서xxxxxx 
		Posts posts = Posts.builder().author("wow").title("새로운 방식").content("builder사용방법").build(); 
		postRepository.save(posts);
	}

	
	@AfterAll   // ""모든"" 테스트를 끝내고 실행되며, 테스트 자료 삭제 [	@Transactional, @Rollback(true)대체가능.]
	public void tearDown() throws Exception {
		postRepository.deleteAll();
	}
}
