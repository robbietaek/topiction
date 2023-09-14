package com.fiction.web.fictboard.controller;

import com.fiction.web.fictboard.dto.PostsListResponseDto;
import com.fiction.web.fictboard.dto.PostsResponseDto;
import com.fiction.web.fictboard.dto.PostsSaveRequestDto;
import com.fiction.web.fictboard.dto.PostsUpdateRequestDto;
import com.fiction.web.fictboard.service.PostsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/posts")
public class PostsApiController {

  private final PostsService postsService;

  @GetMapping
  public List<PostsListResponseDto> findAll() {
    return postsService.findAllDesc();
  }

  @PostMapping
  public Long save(@RequestBody PostsSaveRequestDto requestDto) {
    return postsService.save(requestDto);
  }

  @PutMapping("/{id}")
  public Long update(@PathVariable long id, @RequestBody PostsUpdateRequestDto requestDto) {
    return postsService.update(id, requestDto);
  }

  @GetMapping("/{id}")
  public PostsResponseDto findById(@PathVariable Long id) {
    return postsService.findById(id);
  }

  @DeleteMapping("/{id}")
  public Long delete(@PathVariable Long id) {
    postsService.delete(id);
    return id;
  }


}
