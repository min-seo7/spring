package com.example.demo.dto;

import com.example.demo.domain.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {  //Posts의 Entity를 바로 사용하는것이 아니라 DTO를 거쳐서 사용. 

	private String title;
	private String content;
	private String author;
	
	@Builder
	public PostsSaveRequestDto(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	public Posts toEntity() {
		return Posts.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
				
	}
}