package com.fiction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FictionApplication {

  public static void main(String[] args) {
    SpringApplication.run(FictionApplication.class, args);
  }
}
