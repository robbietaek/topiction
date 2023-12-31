package com.fiction.domain.user;

import com.fiction.domain.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String email;

  @Column
  private String picture;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private RoleType roleType;

  @Builder
  public User(String name, String email, String picture, RoleType roleType) {
    this.name = name;
    this.email = email;
    this.picture = picture;
    this.roleType = roleType;
  }

  public User update(String name, String picture) {
    this.name = name;
    this.picture = picture;
    return this;
  }

  public String getRoleKey() {
    return this.roleType.getKey();
  }

}
