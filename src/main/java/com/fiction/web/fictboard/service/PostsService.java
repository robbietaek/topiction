package com.fiction.web.fictboard.service;

import com.fiction.domain.posts.PostRepository;
import com.fiction.domain.posts.Posts;
import com.fiction.web.fictboard.dto.PostsListResponseDto;
import com.fiction.web.fictboard.dto.PostsResponseDto;
import com.fiction.web.fictboard.dto.PostsSaveRequestDto;
import com.fiction.web.fictboard.dto.PostsUpdateRequestDto;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostsService {

  private final PostRepository postsRepository;

  @Transactional
  public Long save(PostsSaveRequestDto requestDto) {
    return postsRepository.save(requestDto.toEntity()).getId();
  }

  @Transactional
  public Long update(Long id, PostsUpdateRequestDto requestDto) {
    Posts posts = postsRepository.findById(id).orElseThrow(() ->
        new IllegalArgumentException("해당 소설이 없습니다. id=" + id));

    posts.update(requestDto.getTitle(), requestDto.getContent());
    return id;
  }

  public PostsResponseDto findById(Long id) {
    Posts entity = postsRepository.findById(id).orElseThrow(() ->
        new IllegalArgumentException("해당 소설이 없습니다. id=" + id));

    return new PostsResponseDto(entity);
  }

  @Transactional
  public List<PostsListResponseDto> findAllDesc() {
    return postsRepository.findAllDesc().stream()
        .map(PostsListResponseDto::new)
        .collect(Collectors.toList());
  }


}
