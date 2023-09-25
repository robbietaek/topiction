package com.payment.domain.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Getter
@NoArgsConstructor
@Entity
public class Orders {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderId;

  @Column(nullable = false)
  private Long fictionId;

  @Column(nullable = false)
  private Long userId;

  @Column(nullable = false)
  private Long price;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private OrdersType orderType;

  @CreatedDate
  private LocalDateTime orderDate;

  @Builder
  public Orders(Long fictionId, Long userId, OrdersType orderType, Long price,
      LocalDateTime orderDate) {
    this.fictionId = fictionId;
    this.userId = userId;
    this.orderType = orderType;
    this.price = price;
    this.orderDate = orderDate;
  }

  public void update(OrdersType orderType) {
    this.orderType = orderType;
  }

}
