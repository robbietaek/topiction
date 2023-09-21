package com.fiction.web.fictboard.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FictionUpdateRequestDto {

  private String title;
  private String content;

  @Builder
  public FictionUpdateRequestDto(String title, String content) {
    this.title = title;
    this.content = content;
  }
}
