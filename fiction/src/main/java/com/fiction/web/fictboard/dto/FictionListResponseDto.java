package com.fiction.web.fictboard.dto;

import com.fiction.domain.fiction.Fiction;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class FictionListResponseDto {

  private Long fictionId;
  private String title;
  private String author;
  private LocalDateTime modifiedDate;

  public FictionListResponseDto(Fiction entity) {
    this.fictionId = entity.getFictionId();
    this.title = entity.getTitle();
    this.author = entity.getAuthor();
    this.modifiedDate = entity.getModifiedDate();
  }

}
