package com.fiction.web.fictboard.service;

import com.fiction.domain.fiction.Fiction;
import com.fiction.domain.fiction.FictionRepository;
import com.fiction.web.fictboard.dto.FictionListResponseDto;
import com.fiction.web.fictboard.dto.FictionResponseDto;
import com.fiction.web.fictboard.dto.FictionSaveRequestDto;
import com.fiction.web.fictboard.dto.FictionUpdateRequestDto;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FictionService {

  private final FictionRepository fictionRepository;

  @Transactional
  public Long save(FictionSaveRequestDto requestDto) {
    return fictionRepository.save(requestDto.toEntity()).getFictionId();
  }

  @Transactional
  public Long update(Long fictionId, FictionUpdateRequestDto requestDto) {
    Fiction fiction = fictionRepository.findById(fictionId).orElseThrow(() ->
        new IllegalArgumentException("해당 소설이 없습니다. fictionId=" + fictionId));

    fiction.update(requestDto.getTitle(), requestDto.getContent());
    return fictionId;
  }

  public FictionResponseDto findById(Long fictionId) {
    Fiction entity = fictionRepository.findById(fictionId).orElseThrow(() ->
        new IllegalArgumentException("해당 소설이 없습니다. fictionId=" + fictionId));

    return new FictionResponseDto(entity);
  }

  @Transactional
  public List<FictionListResponseDto> findAllDesc() {
    return fictionRepository.findAllDesc().stream()
        .map(FictionListResponseDto::new)
        .collect(Collectors.toList());
  }

  @Transactional
  public void delete(Long fictionId) {
    Fiction fiction = fictionRepository.findById(fictionId).orElseThrow(() ->
        new IllegalArgumentException("해당 소설이 없습니다 fictionId=" + fictionId));
    fictionRepository.delete(fiction);
  }


}
