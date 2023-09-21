package com.payment.domain.payment;

import com.payment.domain.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Order extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderId;

  @Column(nullable = false)
  private Long fictionId;

  @Column(nullable = false)
  private Long price;

  @Column(nullable = false)
  private Date buyingDate;

  @Builder
  public Order(Long orderId, Long fictionId, Long price, Date buyingDate) {
    this.orderId = orderId;
    this.fictionId = fictionId;
    this.price = price;
    this.buyingDate = buyingDate;
  }

}
