package com.fiction.web.fictboard.dto;

import com.fiction.domain.fiction.Fiction;
import lombok.Getter;

@Getter
public class FictionResponseDto {

  private Long fictionId;
  private String title;
  private String content;
  private String author;

  public FictionResponseDto(Fiction entity) {
    this.fictionId = entity.getFictionId();
    this.title = entity.getTitle();
    this.content = entity.getContent();
    this.author = entity.getAuthor();
  }
}
