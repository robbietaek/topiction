package com.fiction.web.fictboard.dto;

import com.fiction.domain.fiction.Fiction;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FictionSaveRequestDto {

  private String title;
  private String content;
  private String author;

  @Builder
  public FictionSaveRequestDto(String title, String content, String author) {
    this.title = title;
    this.content = content;
    this.author = author;
  }

  public Fiction toEntity() {
    return Fiction.builder().title(title).content(content).author(author).build();
  }

}
