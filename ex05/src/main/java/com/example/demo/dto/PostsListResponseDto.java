package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.domain.Posts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class PostsListResponseDto {

	private Long id;  
	private String title;
	private String author;
	
	private LocalDateTime modifiedDate;
	
	public PostsListResponseDto() {};
	
	public PostsListResponseDto(Posts entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.author = entity.getAuthor();
		this.modifiedDate = entity.getModifiedDate();
	}
}
