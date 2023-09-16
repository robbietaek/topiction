package com.fiction.config.auth;


import com.fiction.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

  private final CustomOAuth2UserService customOAuth2UserService;

  @Bean
  public SecurityFilterChain filterChanin(HttpSecurity http) throws Exception {
    return
        http
            .csrf(AbstractHttpConfigurer::disable).headers(headers -> headers.disable())
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/", "/css/**", "/images/**", "/js/**").permitAll()
                .requestMatchers("/api/v1/").hasRole(Role.USER.name())
                .anyRequest().authenticated())
            .logout(logout -> logout
                .logoutSuccessUrl("/"))
            .oauth2Login(oauthLogin -> oauthLogin
                .userInfoEndpoint(userInfoEndpointConfig -> userInfoEndpointConfig
                    .userService(customOAuth2UserService))).build();
  }

}
