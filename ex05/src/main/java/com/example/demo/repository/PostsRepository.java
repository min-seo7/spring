package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Posts;
import com.example.demo.dto.PostsListResponseDto;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long>{ // extends JpaRepository<Posts, Long>는 spring이 제공하는 CRUD 자동생성   <클래스이름, ID의 타입>을 넣어주면 됨. 
	//JpaRepository가 CRUD 메서드를 이미 다 구현해주기 때문에, 별도의 메서드 정의할 필요가 없음. 
	
	//페이징용으로 사용. 
	@Query("SELECT p FROM Posts p ")
	Page<PostsListResponseDto> findAllPage(Pageable pageable);
	
}
