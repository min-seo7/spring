package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Posts;
import com.example.demo.dto.PostsListResponseDto;
import com.example.demo.dto.PostsSaveRequestDto;
import com.example.demo.dto.PostsUpdateRequestDto;
import com.example.demo.repository.PostsRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {

	private final PostsRepository postsRepository;

    @Transactional  
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
    
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
    
    //페이징 조회
    public Page<PostsListResponseDto> findAllPaging(Pageable pageable) {
    	return postsRepository.findAllPage(pageable);
    }
    
}
