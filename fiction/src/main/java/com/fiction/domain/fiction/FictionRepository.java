package com.fiction.domain.fiction;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FictionRepository extends JpaRepository<Fiction, Long> {

  @Query(value = "SELECT p FROM Fiction p ORDER BY p.fiction_id DESC", nativeQuery = true)
  List<Fiction> findAllDesc();

}
