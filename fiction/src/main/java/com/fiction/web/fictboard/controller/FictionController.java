package com.fiction.web.fictboard.controller;

import com.fiction.web.fictboard.dto.FictionListResponseDto;
import com.fiction.web.fictboard.dto.FictionResponseDto;
import com.fiction.web.fictboard.dto.FictionSaveRequestDto;
import com.fiction.web.fictboard.dto.FictionUpdateRequestDto;
import com.fiction.web.fictboard.service.FictionService;
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
@RequestMapping("/api/v1/fiction")
public class FictionController {

  private final FictionService fictionService;

  @GetMapping
  public List<FictionListResponseDto> findAll() {
    return fictionService.findAllDesc();
  }

  @PostMapping
  public Long save(@RequestBody FictionSaveRequestDto requestDto) {
    return fictionService.save(requestDto);
  }

  @PutMapping("/{id}")
  public Long update(@PathVariable long fictionId,
      @RequestBody FictionUpdateRequestDto requestDto) {
    return fictionService.update(fictionId, requestDto);
  }

  @GetMapping("/{id}")
  public FictionResponseDto findById(@PathVariable Long id) {
    return fictionService.findById(id);
  }

  @DeleteMapping("/{id}")
  public Long delete(@PathVariable Long fictionId) {
    fictionService.delete(fictionId);
    return fictionId;
  }


}
