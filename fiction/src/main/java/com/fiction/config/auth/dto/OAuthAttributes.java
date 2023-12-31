package com.fiction.config.auth.dto;

import com.fiction.domain.user.RoleType;
import com.fiction.domain.user.User;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthAttributes {

  private Map<String, Object> attributes;
  private String nameAttributekey;
  private String name;
  private String email;
  private String picture;

  @Builder
  public OAuthAttributes(Map<String, Object> attributes, String nameAttributekey, String name,
      String email, String picture) {
    this.attributes = attributes;
    this.nameAttributekey = nameAttributekey;
    this.name = name;
    this.email = email;
    this.picture = picture;
  }

  public static OAuthAttributes of(String registrationId, String userNameAttributeName,
      Map<String, Object> attributes) {

    if ("naver".equals(registrationId)) {
      return ofNaver("id", attributes);
    }

    return ofGoole(userNameAttributeName, attributes);
  }

  private static OAuthAttributes ofGoole(String userNameAttributeName,
      Map<String, Object> attributes) {
    return OAuthAttributes.builder()
        .name((String) attributes.get("name"))
        .email((String) attributes.get("email"))
        .picture((String) attributes.get("picture"))
        .attributes(attributes)
        .nameAttributekey(userNameAttributeName)
        .build();
  }

  private static OAuthAttributes ofNaver(String userNameAttributeName,
      Map<String, Object> attributes) {
    Map<String, Object> response = (Map<String, Object>) attributes.get("response");

    return OAuthAttributes.builder()
        .name((String) response.get("name"))
        .email((String) response.get("email"))
        .picture((String) response.get("profile_image"))
        .attributes(response)
        .nameAttributekey(userNameAttributeName)
        .build();
  }

  public User toEntity() {
    return User.builder()
        .name(name)
        .email(email)
        .picture(picture)
        .roleType(RoleType.GUEST)
        .build();
  }
}
