package com.example.demo.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.PostsRepository;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor  //파라미터가 없는 기본 생성자 생성
public class PostsUpdateRequestDto {  //업데이트용 DTO

	
	@Autowired PostsRepository postsRepository;
	
	private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
    
   
}
